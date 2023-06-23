package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class AttendanceEntryType {
	@Id
	private int attendanceEntryTypeId;
	@NotEmpty(message = "mention entry type")
	@Enumerated(EnumType.STRING)
	private AtEntryTypeName attendanceEntryTypeName;


}
