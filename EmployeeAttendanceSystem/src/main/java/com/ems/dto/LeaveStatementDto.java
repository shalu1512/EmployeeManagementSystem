package com.ems.dto;

import java.time.Month;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LeaveStatementDto {
	private Month month;
	private Year year;
	private double casualOpeningBalance;
	private double medicalOpeningBalance;
	private double casualUsed;
	private double medicalUsed;
	private double casualClosingBalance;
	private double medicalClosingBalance;
	private int userId;
	
	
	
	
	
	

}
