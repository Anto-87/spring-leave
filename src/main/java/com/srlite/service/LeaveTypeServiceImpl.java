package com.srlite.service;

import java.util.List;
import java.util.stream.Collectors;

import com.srlite.dto.LeaveTypeDTO;
import com.srlite.entity.LeaveType;
import com.srlite.mapper.LeaveTypeMapper;
import com.srlite.repository.LeaveTypeRepository;

import org.springframework.stereotype.Service;

/**
 * Implementing the services offered in interface defined LeaveTypeService
 */
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeServiceImpl(final LeaveTypeRepository leaveTypeRepository){
        this.leaveTypeRepository = leaveTypeRepository;
    }

    /**
     *  Creating the new leaveType entry by passing the DTO reference as parameter
     */
    @Override
    public LeaveTypeDTO createLeaveType(LeaveTypeDTO leaveTypeDTO) {
        leaveTypeDTO.setTypeName(leaveTypeDTO.getTypeName());
        leaveTypeDTO.setStatus(leaveTypeDTO.getStatus());
        LeaveType leaveType = leaveTypeRepository.save(LeaveTypeMapper.mapToEntity(leaveTypeDTO));
        return LeaveTypeMapper.mapToDTO(leaveType);
    }

    /**
     *  To get all the leaveTypes from the table
     */
    @Override
    public List<LeaveTypeDTO> getAllLeaveTypes() {
       return leaveTypeRepository.findAll()
              .stream()
              .map((leaveType)->LeaveTypeMapper.mapToDTO(leaveType))
              .collect(Collectors.toList());
    }

    @Override
    public LeaveTypeDTO getLeaveTypeById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LeaveTypeDTO> searchOnLeaveType(String typeName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LeaveTypeDTO updateLeaveType(LeaveTypeDTO leaveTypeDTO) {
        // TODO Auto-generated method stub
        return null;
    }

   

    
}
