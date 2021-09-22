package com.srlite.dto;

/**
 * Creating the DTO for LeaveType entity
 */
public class LeaveTypeDTO {

    private Long leaveTypeID;
    
    private String typeName;

    private String status;


    public Long getLeaveTypeID() {
        return leaveTypeID;
    }

    public void setLeaveTypeID(Long leaveTypeID) {
        this.leaveTypeID = leaveTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
