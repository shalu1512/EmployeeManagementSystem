package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.RoleDto;
import com.ems.dto.UserDto;
import com.ems.entity.Role;
import com.ems.entity.RoleName;
import com.ems.entity.User;
import com.ems.repository.RoleRepository;
import com.ems.repository.UserRepository;

@Service
public class UserDtoService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public UserDto createUser(UserDto udto) {
		// convert dto to entity
		User user = mapToEntity(udto);
		User newUser = userRepository.save(user);

		// convery entity to dto
		UserDto userResponse = mapToDto(newUser);
		return userResponse;

	}

	public User mapToEntity(UserDto ud) {
		User user = new User();
		Role role = new Role();

		user.setUserName(ud.getUsername());
		user.setUserEmail(ud.getUseremail());
		user.setUserStatus(ud.getUserstatus());

		role.setRoleId(ud.getRoleid());
		user.setRole(role);

		Optional<Role> optionalRole = roleRepository.findById(ud.getRoleid());
		if (optionalRole.isPresent()) {
			role = optionalRole.get();
		}

		if (role.getRoleName() == RoleName.ADMIN) {
			user.setManager(null);
		}

		else if (role.getRoleName() == RoleName.MANAGER) {
			Optional<User> admin = userRepository.findById(ud.getManagerId());
			if (admin.isPresent()) {
				User user2 = admin.get();
				int managerId = user2.getUserId();

				User manager = new User();
				manager.setUserId(managerId);

				user.setManager(manager);
			}
		} else if (role.getRoleName() == RoleName.EMPLOYEE) {
			Optional<User> employeeOptional = userRepository.findById(ud.getManagerId());
			if (employeeOptional.isPresent()) {
				User user2 = employeeOptional.get();
				int managerId = user2.getUserId();

				User manager = new User();
				manager.setUserId(managerId);

				user.setManager(manager);
			}

		}

		else {
			user.setManager(null);
		}

		return user;

	}

	private UserDto mapToDto(User user) {
		UserDto usrDto = new UserDto();
		RoleDto roleDto = new RoleDto();

		usrDto.setUsername(user.getUserName());
		usrDto.setUseremail(user.getUserEmail());
		usrDto.setUserstatus(user.getUserStatus());
		usrDto.setManagerId((user.getUserId()));

		roleDto.setRoleId(user.getRole().getRoleId());
		usrDto.setRoleid(roleDto.getRoleId());
		return usrDto;
	}

}
