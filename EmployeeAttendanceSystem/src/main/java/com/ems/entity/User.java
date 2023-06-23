package com.ems.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message = "name must be required")
	private String userName;
	@Email(message = "enter valid email address")
	private String userEmail;
	
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name ="role_id",referencedColumnName = "roleId")
	private Role role;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="manager_id",referencedColumnName = "userId")
	private User manager;
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	
	
	

}
