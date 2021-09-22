package com.srlite.controller;


import com.srlite.dto.LeaveTypeDTO;
import com.srlite.service.LeaveTypeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creating Rest API call to implement the CRUD services for leaveType entity
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rest/leave-types")
public class LeaveTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveTypeController.class);
    
    private final LeaveTypeService leaveTypeService; 

    public LeaveTypeController(final LeaveTypeService leaveTypeService){
        this.leaveTypeService = leaveTypeService;
    }

    /**
     * To get the datas from the LeaveTypes table
     * @return
     */
    @GetMapping
    public ResponseEntity<?> retrieveAllLeaveTypes(){
        LOGGER.info("API to reterive all the leave types");
        return new ResponseEntity<>(leaveTypeService.getAllLeaveTypes(), HttpStatus.OK);
    }

    /**
     * To create the new LeaveType 
     * @param leaveTypeDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createLevaeType(@RequestBody LeaveTypeDTO leaveTypeDTO){
        LOGGER.info("creating the new leave type");
        return  new ResponseEntity<>(leaveTypeService.createLeaveType(leaveTypeDTO), HttpStatus.OK);
    }


    
}
