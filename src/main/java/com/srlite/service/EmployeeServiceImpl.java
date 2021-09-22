package com.srlite.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.srlite.dto.EmployeeDTO;
import com.srlite.entity.Employee;
import com.srlite.mapper.EmployeeMapper;
import com.srlite.repository.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

/**
 * Implementing the services offered in interface defined EmployeeService
 */
@Service 
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository; 

    public EmployeeServiceImpl(final EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }

    /**
     * To create new employee
     */
    @Override
    public Employee createEmployee(Employee employeeDTO) {

        if(employeeDTO.getReportingTo() != null){
            Employee employee = employeeRepository.findByEmployeeId(employeeDTO.getReportingTo().getEmployeeId());
            employeeDTO.setReportingTo(employee);
        }
        
        employeeDTO.setRole("ROLE_USER");
        employeeDTO.setPassword("testuser");
        employeeDTO.setCreatedAt((java.util.Date) new Date());
        employeeDTO.setEmployeeId(employeeDTO.getEmployeeId());
        employeeDTO.setUserName(employeeDTO.getUserName());
        employeeDTO.setPassword(employeeDTO.getPassword());
        employeeDTO.setRole(employeeDTO.getRole());
        employeeDTO.setFirstName(employeeDTO.getFirstName());
        employeeDTO.setMiddleName(employeeDTO.getMiddleName());
        employeeDTO.setLastName(employeeDTO.getLastName());
        employeeDTO.setEmail(employeeDTO.getEmail());
        employeeDTO.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeDTO.setCreatedAt(employeeDTO.getCreatedAt());
        employeeDTO.setStatus(employeeDTO.getStatus());
      

        return employeeRepository.save(employeeDTO);
     
    }

    /**
     *  To get all the employee details
     */
    @Override
    public List<EmployeeDTO> getAllEmployeeDetails() {
       return employeeRepository.findAll().stream()
              .map((employee)-> EmployeeMapper.mapToDTOWithSupervisor(employee))
              .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO authenticateUserCredentials(String username, String password) {
        Employee returnEmployee =  employeeRepository.findByUserNameAndPassword(username, password);    
        return EmployeeMapper.maptoDTO(returnEmployee);
    }
    
  
    @Override
    public EmployeeDTO getAuthenticateUserDetails(String username) {
        Employee returnEmployee =  employeeRepository.findByUserName(username);    
        return EmployeeMapper.mapToDTOWithSupervisor(returnEmployee);
        
        
    }

    @Override
    public List<EmployeeDTO> getEmployeeByReportingTo(Long reportingID) {
       Employee returnEmployee =  employeeRepository.findByEmployeeId(reportingID);    
       return employeeRepository.findByReportingTo(returnEmployee).stream()
        .map((employee)-> EmployeeMapper.maptoDTO(employee))
        .collect(Collectors.toList());
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        
        Employee emp = employeeRepository.findByEmployeeId(employee.getEmployeeId());
        if(employee.getReportingTo() != null){
            Employee reporting = employeeRepository.findByEmployeeId(employee.getReportingTo().getEmployeeId());
            emp.setReportingTo(reporting);
        }
        emp.setStatus(employee.getStatus());

        return employeeRepository.save(emp);
    }

    @Override
    public Employee updatePassword(String userName, String oldPassword, String newPassword) {
      
        Employee emp = employeeRepository.findByUserNameAndPassword(userName, oldPassword);

        if(emp!=null){
            emp.setPassword(newPassword);
            employeeRepository.save(emp);
            return emp;
        }else{
            throw new ResourceAccessException("Invalid Credentials!!");
        }


    }

   
}
