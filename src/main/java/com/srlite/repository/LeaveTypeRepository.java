package com.srlite.repository;
import java.util.List;

import com.srlite.entity.LeaveType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creating the interface for LeaveType entity
 */
@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long>{

    LeaveType findByLeaveTypeID(Long leaveTypeID);
   // List<LeaveType> findAllByTypeNameContaining(String typeName);

    
}
