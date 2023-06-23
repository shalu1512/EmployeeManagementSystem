package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.ProfileDetailDto;
import com.ems.entity.ProfileDetail;
import com.ems.entity.Technology;
import com.ems.entity.User;
import com.ems.repository.ProfiledetailRepository;

@Service
public class ProfileDetailService {
	@Autowired
	ProfiledetailRepository profiledetailRepository;
	public ProfileDetail saveDetail(ProfileDetailDto profileDetailDto)
	{
		ProfileDetail profileDetail=mapToEntity(profileDetailDto);
		ProfileDetail newProfileDetail=profiledetailRepository.save(profileDetail);
		return newProfileDetail;
		
		
	}
	
		public ProfileDetail mapToEntity(ProfileDetailDto profileDetailDto)
	
	{
		
			ProfileDetail profileDetail=new ProfileDetail();
			Technology technology=new Technology();
            User user=new User();
			profileDetail.setEmpDob(profileDetailDto.getEmpDob());
			profileDetail.setEmpAddress(profileDetailDto.getEmpAddress());
			profileDetail.setEmpExperiance(profileDetailDto.getEmpExperiance());
			profileDetail.setEmpGender(profileDetailDto.getEmpGender());
			profileDetail.setEmpMobile(profileDetailDto.getEmpMobile());
			profileDetail.setEmpQualification(profileDetailDto.getEmpQualification());
			profileDetail.setEmpState(profileDetailDto.getEmpState());
			technology.setTechName(profileDetailDto.getTechName());
			technology.getTechName();
			technology.getTechId();
			profileDetail.setTech(technology);
			user.getUserId();
			profileDetail.setUser(user);
			return profileDetail;
			

			
		
		
	}

}
