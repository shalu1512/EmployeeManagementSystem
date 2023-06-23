package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {

}
