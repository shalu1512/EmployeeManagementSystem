package com.ems.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class ProfileDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empDetailId;
	@DateTimeFormat(fallbackPatterns = "dd/mm/yy")
	private Date empDob;
	@Enumerated(EnumType.STRING)
	private Qualification empQualification;
	@Size(min=10,max = 10)
	private String empMobile;
	private String empAddress;
	@NotEmpty
	private String empState;
	@Column(nullable = true)
	private int empExperiance;
	@Enumerated(EnumType.STRING)
	private Gender empGender;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tech_id",referencedColumnName = "techId")
	private Technology tech;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "userId")
	private User user;

	

}
