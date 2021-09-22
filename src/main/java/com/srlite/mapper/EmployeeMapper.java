package com.srlite.mapper;

import com.srlite.dto.EmployeeDTO;
import com.srlite.entity.Employee;

/**
 * Mapper to convert the map to DTO and vice versa for [Employee] entity
 */
public class EmployeeMapper {

    /**
     * Return the DTO reference for Employee entity
     * 
     * @param employee
     * @return
     */
    public static EmployeeDTO maptoDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeID(employee.getEmployeeId());
        employeeDTO.setUserName(employee.getUserName());
        // employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setMiddleName(employee.getMiddleName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setCreatedAt(employee.getCreatedAt());
        employeeDTO.setStatus(employee.getStatus());
       
        return employeeDTO;

    }

    /**
     * Return the map referenc for Employee entity
     * 
     * @param employeeDTO
     * @return
     */
    public static Employee maptoEntity(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setEmployeeId(employeeDTO.getEmployeeID());
        employee.setUserName(employeeDTO.getUserName());
        employee.setPassword(employeeDTO.getPassword());
        employee.setRole(employeeDTO.getRole());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setCreatedAt(employeeDTO.getCreatedAt());
        employee.setStatus(employeeDTO.getStatus());
    
        return employee;

    }

    public static EmployeeDTO mapToDTOWithSupervisor(Employee employee) {
        EmployeeDTO employeeDTO = maptoDTO(employee);
        if (employee.getReportingTo() != null) {
            employeeDTO.setReportingTo(EmployeeMapper.maptoDTO(employee.getReportingTo()));
        }
        return employeeDTO;
    }

    public static Employee mapToEntityWithSupervisor(EmployeeDTO employeeDTO) {
        Employee employee = maptoEntity(employeeDTO);
        if (employeeDTO.getReportingTo() != null) {
            employee.setReportingTo(EmployeeMapper.maptoEntity(employeeDTO.getReportingTo()));
        }
        return employee;
    }
    

}
