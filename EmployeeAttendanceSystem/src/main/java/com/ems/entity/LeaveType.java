package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LeaveType {
	@Id
	private int leave_type_id;
	@Enumerated(EnumType.STRING)
	private Lvtype leave_type;
	

}
