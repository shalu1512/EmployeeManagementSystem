package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.AttendanceEntryType;

public interface AttendanceEntryTypeRepository extends JpaRepository<AttendanceEntryType, Integer>{

}
