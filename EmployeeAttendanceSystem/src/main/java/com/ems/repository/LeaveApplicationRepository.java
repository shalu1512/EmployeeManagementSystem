package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.LeaveApplication;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {

}
