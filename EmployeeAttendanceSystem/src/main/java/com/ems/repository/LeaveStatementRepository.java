package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.LeaveStatement;

public interface LeaveStatementRepository extends JpaRepository<LeaveStatement, Integer>{
	

}
