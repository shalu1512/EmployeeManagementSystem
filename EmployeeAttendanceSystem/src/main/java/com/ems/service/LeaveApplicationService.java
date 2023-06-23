package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.LeaveApplicationDto;
import com.ems.entity.LeaveApplication;
import com.ems.entity.LeaveType;
import com.ems.entity.User;
import com.ems.repository.LeaveApplicationRepository;
import com.ems.repository.LeaveTypeRepository;
import com.ems.repository.UserRepository;

@Service
public class LeaveApplicationService {
	@Autowired
	LeaveApplicationRepository leaveApplicationRepository;
	@Autowired
	LeaveTypeRepository leaveTypeRepository;
	@Autowired
	UserRepository userRepository;

	public LeaveApplication saveLeaveApplication(LeaveApplicationDto leaveApplicationDto) {
		LeaveApplication leaveApplication = mapToEntity(leaveApplicationDto);
		return leaveApplicationRepository.save(leaveApplication);
	}

	public LeaveApplication mapToEntity(LeaveApplicationDto leaveApplicationDto) {
		LeaveApplication leaveApplication = new LeaveApplication();

		leaveApplication.setCreatedAt(leaveApplicationDto.getCreatedAt());
		leaveApplication.setLeaveEndDate(leaveApplicationDto.getLeaveEndDate());
		leaveApplication.setLeaveEndPeriod(leaveApplicationDto.getLeaveEndPeriod());
		leaveApplication.setLeaveMessage(leaveApplicationDto.getLeaveMessage());
		leaveApplication.setLeaveStartDate(leaveApplicationDto.getLeaveStartDate());
		leaveApplication.setLeaveStartPeriod(leaveApplicationDto.getLeaveStartPeriod());
		leaveApplication.setAproovedBy(leaveApplicationDto.getAprooved_by());
		

		Optional<LeaveType> optionalleaveType = leaveTypeRepository.findById(leaveApplicationDto.getLeaveTypeId());
		if (optionalleaveType.isPresent()) {
			LeaveType leaveType = optionalleaveType.get();
			int leaveTypeId = leaveType.getLeave_type_id();
			leaveType.setLeave_type_id(leaveTypeId);
			leaveApplication.setLt(leaveType);

		}

		Optional<User> user = userRepository.findById(leaveApplicationDto.getUserId());
		if (user.isPresent()) {
			User user2 = user.get();
			int userId = user2.getUserId();
			user2.setUserId(userId);
			leaveApplication.setUser(user2);
		}

		return leaveApplication;

	}

}
