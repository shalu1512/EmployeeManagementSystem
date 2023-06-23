package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.AttendanceDto;
import com.ems.dto.LeaveApplicationDto;
import com.ems.dto.LeaveStatementDto;
import com.ems.dto.ProfileDetailDto;
import com.ems.dto.UserDto;
import com.ems.entity.Attendance;
import com.ems.entity.LeaveApplication;
import com.ems.entity.LeaveStatement;
import com.ems.entity.ProfileDetail;
import com.ems.service.AttendanceService;
import com.ems.service.LeaveApplicationService;
import com.ems.service.LeaveStatementService;
import com.ems.service.ProfileDetailService;
import com.ems.service.UserDtoService;

@RestController
@RequestMapping("/ems")
public class UserController {
	@Autowired
	UserDtoService userDtoService;
	@Autowired
	ProfileDetailService profileDetailService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	LeaveApplicationService leaveApplicationService;
	@Autowired
	LeaveStatementService leaveStatementService;
	@PostMapping("/user")
	public UserDto saveUser(@RequestBody UserDto userDto)
	{
		return userDtoService.createUser(userDto);
		
	}
	@PostMapping("/userDetail")
	public ProfileDetail saveDetail(@RequestBody ProfileDetailDto profileDetailDto)
	{
		return profileDetailService.saveDetail(profileDetailDto);
	}
	@PostMapping("/userAttendance")
	public Attendance saveAttendance(@RequestBody AttendanceDto attendanceDto)
	{
		return attendanceService.saveAttendance(attendanceDto);
	}
	@PostMapping("/leaveApplication")
	public LeaveApplication saveApplication(@RequestBody LeaveApplicationDto leaveApplicationDto)
	{
		return leaveApplicationService.saveLeaveApplication(leaveApplicationDto);
	}
	@PostMapping("/leaveStatement")
	public LeaveStatement saveLeaveStatement(@RequestBody LeaveStatementDto leaveStatementDto)
	{
		return leaveStatementService.saveLeaveStatement(leaveStatementDto);
	}

}
