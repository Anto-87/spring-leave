package com.srlite.mapper;

import com.srlite.dto.LeaveRequestDTO;
import com.srlite.entity.LeaveRequest;

public class LeaveRequestMapper {

    public static LeaveRequestDTO mapToDto(LeaveRequest employeeLeave){
        LeaveRequestDTO employeeLeaveDTO = new LeaveRequestDTO();
        employeeLeaveDTO.setLeaveId(employeeLeave.getLeaveId());
        if(employeeLeave.getEmployeeID() != null) {
            employeeLeaveDTO.setEmployeeID(EmployeeMapper.maptoDTO(employeeLeave.getEmployeeID()));
        }
        if(employeeLeave.getLeaveType() != null) {
            employeeLeaveDTO.setLeaveType(LeaveTypeMapper.mapToDTO(employeeLeave.getLeaveType()));
        }
        employeeLeaveDTO.setLeaveReason(employeeLeave.getLeaveReason());
        employeeLeaveDTO.setFromDate(employeeLeave.getFromDate());
        employeeLeaveDTO.setToDate(employeeLeave.getToDate());
        employeeLeaveDTO.setDeniedReason(employeeLeave.getDeniedReason());
        employeeLeaveDTO.setStatus(String.valueOf(employeeLeave.getStatus()));
        employeeLeaveDTO.setCreatedAt(employeeLeave.getCreatedAt());
        if(employeeLeave.getApprovedBy() != null) {
            employeeLeaveDTO.setApprovedBy(EmployeeMapper.maptoDTO(employeeLeave.getApprovedBy()));
        }
        return employeeLeaveDTO;
    }

    public static LeaveRequest mapToEntity(LeaveRequestDTO employeeLeaveDTO){
        LeaveRequest employeeLeave = new LeaveRequest();
        employeeLeave.setLeaveId(employeeLeaveDTO.getLeaveId());
        if(employeeLeaveDTO.getEmployeeID() != null) {
            employeeLeave.setEmployeeID(EmployeeMapper.maptoEntity(employeeLeaveDTO.getEmployeeID()));
        }
        if(employeeLeaveDTO.getLeaveType() != null) {
            employeeLeave.setLeaveType(LeaveTypeMapper.mapToEntity(employeeLeaveDTO.getLeaveType()));
        }
        employeeLeave.setLeaveReason(employeeLeaveDTO.getLeaveReason());
        employeeLeave.setFromDate(employeeLeaveDTO.getFromDate());
        employeeLeave.setToDate(employeeLeaveDTO.getToDate());
        employeeLeave.setDeniedReason(employeeLeaveDTO.getDeniedReason());
        employeeLeave.setStatus(employeeLeaveDTO.getStatus());
        employeeLeave.setCreatedAt(employeeLeaveDTO.getCreatedAt());
        if(employeeLeaveDTO.getApprovedBy() != null) {
            employeeLeave.setApprovedBy(EmployeeMapper.maptoEntity(employeeLeaveDTO.getApprovedBy()));
        }
        return employeeLeave;
    }
}
