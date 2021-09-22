package com.srlite.dto;

import java.util.Date;

public class LeaveRequestDTO {

    private Long leaveId; 

    private EmployeeDTO employeeID; 

    private LeaveTypeDTO leaveType; 

    private Date fromDate;

    private Date toDate;

    private String leaveReason; 

    private Date createdAt; 

    private String status; 

    private String deniedReason;

    private EmployeeDTO approvedBy;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public EmployeeDTO getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(EmployeeDTO employeeID) {
        this.employeeID = employeeID;
    }

    public LeaveTypeDTO getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveTypeDTO leaveType) {
        this.leaveType = leaveType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeniedReason() {
        return deniedReason;
    }

    public void setDeniedReason(String deniedReason) {
        this.deniedReason = deniedReason;
    }

    public EmployeeDTO getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(EmployeeDTO approvedBy) {
        this.approvedBy = approvedBy;
    }
    
    

}
