package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.AttendanceDto;
import com.ems.entity.Attendance;
import com.ems.entity.AttendanceEntryType;
import com.ems.entity.User;
import com.ems.repository.AttendanceEntryTypeRepository;
import com.ems.repository.AttendanceRepository;
import com.ems.repository.UserRepository;

@Service
public class AttendanceService {
	@Autowired
	AttendanceRepository repository;
	@Autowired
	AttendanceEntryTypeRepository attendanceEntryTypeRepository;
	@Autowired
	UserRepository userRepository;

	public Attendance saveAttendance(AttendanceDto attendanceDto) {
		Attendance attendance = this.mapToEntry(attendanceDto);
		return repository.save(attendance);
	}

	public Attendance mapToEntry(AttendanceDto attendanceDto) {
		Attendance attendance = new Attendance();
		attendance.setAttenadanceDate(attendanceDto.getAttenadanceDate());
		attendance.setInTime(attendanceDto.getInTime());
		attendance.setOutTime(attendanceDto.getOutTime());
		attendance.setCreatedAt(attendanceDto.getCreatedAt());
		attendance.setAproovedBy(attendanceDto.getAproovedBy());
		attendance.setAttendanceSource(attendanceDto.getAttendanceSource());
		attendance.setAttendanceStatus(attendanceDto.getAttendanceStatus());

		Optional<AttendanceEntryType> at = attendanceEntryTypeRepository.findById(attendanceDto.getEntryTypeId());
		if (at.isPresent()) {
			AttendanceEntryType aet = at.get();
			int entryTypeId = aet.getAttendanceEntryTypeId();
			AttendanceEntryType attendanceEntryType2 = new AttendanceEntryType();
			attendanceEntryType2.setAttendanceEntryTypeId(entryTypeId);
			attendance.setAet(attendanceEntryType2);

		}
		Optional<User> uOptional = userRepository.findById(attendanceDto.getUser_id());
		if (uOptional.isPresent()) {
			User user2 = uOptional.get();
			int userId = user2.getUserId();
			User user3 = new User();
			user3.setUserId(userId);
			attendance.setUser(user3);

		}
		return attendance;

	}
}
