package com.srlite.service;

import java.util.List;

import com.srlite.dto.LeaveRequestDTO;
import com.srlite.entity.LeaveRequest;

public interface LeaveRequestService {
    
    LeaveRequest createEmployeeLeave(LeaveRequest leaveRequestDTO, Long employeeId, Long leaveTypeId);

    List<LeaveRequestDTO> getAllEmployeeLeaveDetails();
    List<LeaveRequestDTO> getLeaveDetailsByEmployee(Long employeeID);
    List<LeaveRequestDTO> getLeaveDetailsByApproval(Long employeeID);

    LeaveRequest updateLeaveRequest(Long employeeId, LeaveRequest leaveRequest);
    
    List<LeaveRequestDTO> findCountByStatus(Long employeeId, String status);
}
