package com.srlite.controller;

import com.srlite.dto.EmployeeDTO;
import com.srlite.entity.Employee;
import com.srlite.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Creating Rest API call to implement the CRUD services for employee entity
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rest/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    /**
     * Create the new employee record 
     * @param employeeDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employeeDTO){

        LOGGER.info("API creating new employee");
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.OK);
        
    }

    /**
     * Get all the employee details
     * @return
     */
    @GetMapping
    public ResponseEntity<?> reteriveAllEmployees(){
        LOGGER.info("API for getting all employees");
        return new ResponseEntity<>(employeeService.getAllEmployeeDetails(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody EmployeeDTO employeeDTO){
        LOGGER.info("API for authenticating user details");
        return new ResponseEntity<>(employeeService.authenticateUserCredentials(employeeDTO.getUserName(), employeeDTO.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<?> retrieveEmployeeByName(@PathVariable String name) {

        LOGGER.info("API Return employee details based on userName");
        return new ResponseEntity<>(employeeService.getAuthenticateUserDetails(name), HttpStatus.OK);
    }
    
    @GetMapping("getByReporting/{reportingId}")
    public ResponseEntity<?> reteriveEmployeeByReporting(@PathVariable (value="reportingId") Long reportingId){

        return new ResponseEntity<>(employeeService.getEmployeeByReportingTo(reportingId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployeeDetails(@RequestBody Employee employee){

        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @PutMapping("/changePassword/{userName}/oldPassword/{oldPassword}/newPassword/{newPassword}")
    public ResponseEntity<?> updatePassword(@PathVariable (value="userName") String userName, 
                    @PathVariable (value="oldPassword") String oldPassword, 
                    @PathVariable (value="newPassword") String newPassword){
        
        return new ResponseEntity<>(employeeService.updatePassword(userName, oldPassword, newPassword), HttpStatus.OK);

    }
}
