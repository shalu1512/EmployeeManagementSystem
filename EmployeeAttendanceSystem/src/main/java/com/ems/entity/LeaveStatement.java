package com.ems.entity;

import java.time.Month;
import java.time.Year;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class LeaveStatement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveStatementId;
	@NotBlank(message = "month must be entered")
	@Size(min=1,max=12)
	private Month month;
	@NotBlank(message = "year must be entered")
	private Year year;
	@PositiveOrZero
	private double casualOpeningBalance;
	@PositiveOrZero
	private double medicalOpeningBalance;
    @PositiveOrZero
	private double casualUsed;
    @PositiveOrZero
	private double medicalUsed;
    @PositiveOrZero
	private double casualClosingBalance;
    @PositiveOrZero
	private double medicalClosingBalance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "userId")
	private User user;
}
