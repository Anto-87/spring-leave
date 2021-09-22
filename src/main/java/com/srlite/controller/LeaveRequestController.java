package com.srlite.controller;

import com.srlite.dto.LeaveRequestDTO;
import com.srlite.entity.LeaveRequest;
import com.srlite.repository.EmployeeRepository;
import com.srlite.service.EmployeeService;
import com.srlite.service.LeaveRequestService;
import com.srlite.service.LeaveTypeServiceImpl;

import org.apache.catalina.connector.Response;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rest/leave")
public class LeaveRequestController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveRequestController.class);
    
    private LeaveRequestService leaveRequestService;
    private EmployeeService employeeService;

    private LeaveRequestController(LeaveRequestService leaveRequestService){

        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping("/{employeeId}/leaveType/{leaveTypeId}")
    public ResponseEntity<?> createEmployeeLeave(@PathVariable (value = "employeeId") Long employeeId,
                                                @PathVariable (value ="leaveTypeId") Long leaveTypeId,
                                            @RequestBody LeaveRequest leaveDTO){

        return new ResponseEntity<>(leaveRequestService.createEmployeeLeave(leaveDTO, employeeId, leaveTypeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployeLeaveDetails(){

        return new ResponseEntity<>(leaveRequestService.getAllEmployeeLeaveDetails(), HttpStatus.OK);

    }

    @GetMapping("/getByEmployee/{employeeID}")
    public ResponseEntity<?> getLeaveDetailsByEmployeeID(@PathVariable (value="employeeID") Long employeeID){

        return new ResponseEntity<>(leaveRequestService.getLeaveDetailsByEmployee(employeeID), HttpStatus.OK);
    }

    

    @GetMapping("/getEmployeeByReporting/{employeeID}")
    public ResponseEntity<?> getEmployeeByReporting(@PathVariable (value="employeeID") Long employeeID){

        return new ResponseEntity<>(leaveRequestService.getLeaveDetailsByApproval(employeeID), HttpStatus.OK);
    }

    @PutMapping("/update/{employeeID}")
    public ResponseEntity<?> approveorRejectLeave(@PathVariable (value="employeeID") Long employeeID,
                                                    @RequestBody LeaveRequest leaveRequest){

        return new ResponseEntity<>(leaveRequestService.updateLeaveRequest(employeeID, leaveRequest), HttpStatus.OK); 
    }

    @GetMapping("/getCountByStatus/{employeeID}/status/{status}")
    public ResponseEntity<?> getEmployeeCountByStatus(@PathVariable (value="employeeID") Long employeeID,
                                                     @PathVariable (value="status") String status){
        return new ResponseEntity<>(leaveRequestService.findCountByStatus(employeeID, status), HttpStatus.OK);
    }
}
