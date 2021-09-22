package com.srlite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.srlite.entity.Employee;

/**
 * Creating the interface for the Employee table
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    

    //@Override
    //Page<Employee> findAll(Pageable pageable);
    Employee findByEmployeeId(Long employeeID);

    Employee findByUserName(String username);

    Employee findByUserNameAndStatus(String username, String status);

    Employee findByUserNameAndPassword(String username, String password);

    List<Employee> findByReportingTo(Employee reportingTo);
    
    // All employee under supervision of given employee
    //List<Employee> findAllBySupervisor(Employee employee);

    //Page<Employee> findByFirstNameContainingOrMiddleNameContainingOrLastNameContaining(Pageable pageable, String firstName, String middleName, String lastName);
}
