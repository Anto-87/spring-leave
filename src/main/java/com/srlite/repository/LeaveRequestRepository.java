package com.srlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.srlite.entity.Employee;
import com.srlite.entity.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    
    List<LeaveRequest> findAllByEmployeeID(Employee employee);
    List<LeaveRequest> findAllByEmployeeIDInAndStatus(List<Employee> employees, String status);

    Optional<LeaveRequest> findById(Long leaveId);

    List<LeaveRequest> findAllByEmployeeIDAndStatus(Employee employee, String status);

}
