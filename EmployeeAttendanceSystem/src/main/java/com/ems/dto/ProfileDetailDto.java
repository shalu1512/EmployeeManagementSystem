package com.ems.dto;

import java.util.Date;

import com.ems.entity.Gender;
import com.ems.entity.Qualification;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProfileDetailDto {
	private Date empDob;
	private Qualification empQualification;
	private String empMobile;
	private String empAddress;
	private String empState;
	private int empExperiance;
	private Gender empGender;
	private int tech_id;
	private String techName;
	private int user_id;








}
