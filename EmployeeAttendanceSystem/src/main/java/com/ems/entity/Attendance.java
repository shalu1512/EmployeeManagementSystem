package com.ems.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	@NotNull
	private Date attenadanceDate;
	
	@Enumerated(EnumType.STRING)
	private AttendanceSource attendanceSource;
	
	private Time InTime;
	private Time outTime;
	@Column(nullable = true)
	private String attendanceNote;
	@Enumerated(EnumType.STRING)
	private UserStatus attendanceStatus;

	private Date createdAt;
	@NotBlank(message = "manager name required")
	private String aproovedBy;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendance_entry_type", referencedColumnName = "attendanceEntryTypeId")
	private AttendanceEntryType aet;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

}
