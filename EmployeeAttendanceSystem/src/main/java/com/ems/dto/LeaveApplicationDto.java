package com.ems.dto;

import java.util.Date;

import com.ems.entity.LeaveEndPeriod;
import com.ems.entity.LeaveStartPeriod;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LeaveApplicationDto {
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String leaveMessage;
	private Date createdAt;
	
	private String aprooved_by;
	private LeaveStartPeriod leaveStartPeriod;
	private LeaveEndPeriod leaveEndPeriod;
	private int leaveTypeId;
	private int userId;
	
	
	
	
	
	

}
