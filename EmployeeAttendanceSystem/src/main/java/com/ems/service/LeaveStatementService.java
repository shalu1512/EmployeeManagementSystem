package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.LeaveStatementDto;
import com.ems.entity.LeaveStatement;
import com.ems.entity.User;
import com.ems.repository.LeaveStatementRepository;
import com.ems.repository.UserRepository;

@Service
public class LeaveStatementService {
	@Autowired
	LeaveStatementRepository leaveStatementRepository;
	@Autowired
	UserRepository userRepository;
	public LeaveStatement saveLeaveStatement(LeaveStatementDto leaveStatementDto)
	{
		LeaveStatement leaveStatement=mapToEntity(leaveStatementDto);
		return leaveStatementRepository.save(leaveStatement);
		
	}
	public LeaveStatement mapToEntity(LeaveStatementDto leaveStatementDto)
	{
		
		LeaveStatement leaveStatement=new LeaveStatement();
		leaveStatement.setCasualClosingBalance(leaveStatementDto.getCasualClosingBalance());
		leaveStatement.setCasualOpeningBalance(leaveStatementDto.getCasualOpeningBalance());
		leaveStatement.setCasualUsed(leaveStatementDto.getCasualUsed());
		leaveStatement.setMedicalClosingBalance(leaveStatementDto.getMedicalClosingBalance());
		leaveStatement.setMedicalOpeningBalance(leaveStatementDto.getMedicalOpeningBalance());
		leaveStatement.setMedicalUsed(leaveStatementDto.getMedicalUsed());
		leaveStatement.setMonth(leaveStatementDto.getMonth());
		leaveStatement.setYear(leaveStatementDto.getYear());
		
		Optional<User> optionalUser = userRepository.findById(leaveStatementDto.getUserId());
		if(optionalUser.isPresent())
		{
			User user=optionalUser.get();
			int userId=user.getUserId();
			user.setUserId(userId);
			leaveStatement.setUser(user);
			
			
		}
		return leaveStatement;
		
		
	}

}
