package com.srlite.entity;

import javax.persistence.*;

/**
 * Create the entity structure in the form of POJO on LeaveType entity
 */
@Entity
@Table(name="leave_type")
public class LeaveType {

    @Id
    @Column(name="leave_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeID;
    
    @Column(name="type_name", nullable=false)
    private  String typeName;

    @Column(name="status",  nullable=false)
    private  String status;

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
