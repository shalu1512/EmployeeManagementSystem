package com.ems.dto;

import java.sql.Time;
import java.util.Date;

import com.ems.entity.AttendanceSource;
import com.ems.entity.UserStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDto {
	
	private Date attenadanceDate;
	@Enumerated(EnumType.STRING)
	private AttendanceSource attendanceSource;
	private Time InTime;
	private Time outTime;
	@Enumerated(EnumType.STRING)
	private UserStatus attendanceStatus;
	
	private Date createdAt;
	
	@NotBlank(message = "manager/admin name required")
	private String aproovedBy;
	private int entryTypeId;
	private int user_id;

	
	
	

}
