package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techId;
	private String techName;

}
