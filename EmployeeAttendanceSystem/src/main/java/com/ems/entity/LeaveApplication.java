package com.ems.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class LeaveApplication {
	@Id
	private int leaveId;
	@Size(min = 1,max = 31)
	private Date leaveStartDate;
	@Size(min = 1,max = 31)
	private Date leaveEndDate;
	@NotBlank(message = "mention leave reason")
	@Min(3)
	private String leaveMessage;
	private Date createdAt;

	@Column(name = "aprooved_by",nullable = false)
	private String aproovedBy;
	@Enumerated(EnumType.STRING)
	private LeaveStartPeriod leaveStartPeriod;
	@Enumerated(EnumType.STRING)
	private LeaveEndPeriod leaveEndPeriod;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="leave_type_id",referencedColumnName = "leave_type_id") 
	private LeaveType lt;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "userId")
	private User user;
	
	

}
