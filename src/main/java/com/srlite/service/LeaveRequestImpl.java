package com.srlite.service;

import javax.swing.text.AbstractDocument.LeafElement;

import com.srlite.dto.EmployeeDTO;
import com.srlite.dto.LeaveRequestDTO;
import com.srlite.entity.Employee;
import com.srlite.entity.LeaveRequest;
import com.srlite.entity.LeaveType;
import com.srlite.mapper.EmployeeMapper;
import com.srlite.mapper.LeaveRequestMapper;
import com.srlite.repository.EmployeeRepository;
import com.srlite.repository.LeaveRequestRepository;
import com.srlite.repository.LeaveTypeRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LeaveRequestImpl implements LeaveRequestService {

    private LeaveRequestRepository leaveRequestRepository;
    private EmployeeRepository employeeRepository;
    private LeaveTypeRepository leaveTypeRepository;

    public LeaveRequestImpl(LeaveRequestRepository leaveRequestRepository, EmployeeRepository employeeRepository,
                            LeaveTypeRepository leaveTypeRepository){
        this.leaveRequestRepository = leaveRequestRepository;
        this.employeeRepository = employeeRepository;
        this.leaveTypeRepository = leaveTypeRepository;
    }

    @Override
    public LeaveRequest createEmployeeLeave(LeaveRequest leaveRequestDTO, Long employeeID, Long leaveTypeId) {

        Employee employee = employeeRepository.findByEmployeeId(employeeID);
        LeaveType leaveType = leaveTypeRepository.findByLeaveTypeID(leaveTypeId);
        leaveRequestDTO.setEmployeeID(employee);
        leaveRequestDTO.setLeaveType(leaveType);
        leaveRequestDTO.setCreatedAt(new Date());
        leaveRequestDTO.setStatus("SUBMITTED");
        return leaveRequestRepository.save(leaveRequestDTO);
        
    }

    @Override
    public List<LeaveRequestDTO> getAllEmployeeLeaveDetails() {
        return leaveRequestRepository.findAll().stream().
                map((leaveRequest) -> LeaveRequestMapper.mapToDto(leaveRequest))
                .collect(Collectors.toList());
        
    }

    @Override
    public List<LeaveRequestDTO> getLeaveDetailsByEmployee(Long employeeID) {
        Employee employee = employeeRepository.findByEmployeeId(employeeID);
        return leaveRequestRepository.findAllByEmployeeID(employee).stream()
                .map((leaveRequest) -> LeaveRequestMapper.mapToDto(leaveRequest))
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveRequestDTO> getLeaveDetailsByApproval(Long employeeID) {
        Employee employee = employeeRepository.findByEmployeeId(employeeID);
        List<Employee> getAuthorityEmployees =  employeeRepository.findByReportingTo(employee);

       return leaveRequestRepository.findAllByEmployeeIDInAndStatus(getAuthorityEmployees, "SUBMITTED").stream()
       .map((leaveRequest) -> LeaveRequestMapper.mapToDto(leaveRequest))
       .collect(Collectors.toList());
    }

    @Override
    public LeaveRequest updateLeaveRequest(Long employeeId, LeaveRequest body) {
     
     Optional<LeaveRequest> leaveRequest = leaveRequestRepository.findById(body.getLeaveId());
     leaveRequest.get().setDeniedReason(body.getDeniedReason());
     leaveRequest.get().setStatus(body.getStatus());
     
     Employee employee = employeeRepository.findByEmployeeId(employeeId);
     leaveRequest.get().setApprovedBy(employee);

     return leaveRequestRepository.save(leaveRequest.get());

    }

    @Override
    public List<LeaveRequestDTO> findCountByStatus(Long employeeId, String status) {
        
        Employee employee = employeeRepository.findByEmployeeId(employeeId);

        return leaveRequestRepository.findAllByEmployeeIDAndStatus(employee, status).stream()
        .map((leaveRequest) -> LeaveRequestMapper.mapToDto(leaveRequest))
        .collect(Collectors.toList());

    }
    
    
}
