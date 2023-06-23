package com.ems.dto;

import com.ems.entity.UserStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private String username;
	private String useremail;
	private UserStatus userstatus;
	private int roleid;
	private int managerId;
	

}
