package com.srlite.service;

import java.util.List;

import com.srlite.dto.EmployeeDTO;
import com.srlite.entity.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Provides the list of services offered on Employee entity 
 */
public interface EmployeeService {
    
    /**
     * Create the new employee entry
     * @param employeeDTO
     * @return
     */
    Employee createEmployee(Employee employeeDTO);

    
    /**
     * To get all the employee details not by paging method
     * @return
     */
    List<EmployeeDTO> getAllEmployeeDetails();

    EmployeeDTO authenticateUserCredentials(String username, String password);

    EmployeeDTO getAuthenticateUserDetails(String username);

    List<EmployeeDTO> getEmployeeByReportingTo(Long reportingID);

    Employee updateEmployee(Employee employee);

    Employee updatePassword(String userName, String oldPassword, String newPassword);
    
}
