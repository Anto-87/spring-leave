package com.srlite.service;

import java.util.List;

import com.srlite.dto.LeaveTypeDTO;

/**
 * Provides list of services to be offered across the LeaveType entity
 */
public interface LeaveTypeService {
    
    /**
     * To get all leaveTypes
     * @return
     */
    List<LeaveTypeDTO> getAllLeaveTypes();

    /**
     * To get the leaveType based on the ID
     * @param id
     * @return
     */
    LeaveTypeDTO getLeaveTypeById(Long id);

    /**
     * To create the new leaveType
     * @param leaveTypeDTO
     * @return
     */
    LeaveTypeDTO createLeaveType(LeaveTypeDTO leaveTypeDTO);

    /**
     * Update the leaveType entry
     * @param leaveTypeDTO
     * @return
     */
    LeaveTypeDTO updateLeaveType(LeaveTypeDTO leaveTypeDTO);

    /**
     * Search the leaveType based on the string search
     * @param typeName
     * @return
     */
    List<LeaveTypeDTO> searchOnLeaveType(String typeName);

}
