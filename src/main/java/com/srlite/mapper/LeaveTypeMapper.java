package com.srlite.mapper;

import com.srlite.dto.LeaveTypeDTO;
import com.srlite.entity.LeaveType;

/**
 * Mapper to convert the map to DTO and vice versa [LeaveType] entity
 */
public class LeaveTypeMapper {

    /**
     * Return the DTO reference by passing LeaveType entity
     * @param leaveType
     * @return
     */
    public static LeaveTypeDTO mapToDTO(LeaveType leaveType){
        LeaveTypeDTO dto = new LeaveTypeDTO();

        dto.setLeaveTypeID(leaveType.getLeaveTypeID());
        dto.setTypeName(leaveType.getTypeName());
        dto.setStatus(leaveType.getStatus());
        return dto;
        
    }

    /**
     * Return the map reference by passing LeaveTypeDTO reference
     * @param leaveTypeDTO
     * @return
     */
    public static LeaveType mapToEntity(LeaveTypeDTO leaveTypeDTO){

        LeaveType leaveType = new LeaveType();

        leaveType.setLeaveTypeID(leaveTypeDTO.getLeaveTypeID());
        leaveType.setTypeName(leaveTypeDTO.getTypeName());
        leaveType.setStatus(leaveTypeDTO.getStatus());
        return leaveType;

    }
    
}
