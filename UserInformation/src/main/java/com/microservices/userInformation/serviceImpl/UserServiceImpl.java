package com.microservices.userInformation.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.userInformation.dto.UserDTO;
import com.microservices.userInformation.entity.User;
import com.microservices.userInformation.mapper.UserMapper;
import com.microservices.userInformation.repo.UserRepo;
import com.microservices.userInformation.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> getAllUsers = userRepo.findAll();
		List<UserDTO> userDTOList = getAllUsers.stream().map(user -> UserMapper.INSTANCE.mapUserToUserDTO(user)).collect(Collectors.toList());
		return userDTOList;
	}

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	}

	@Override
	public ResponseEntity<UserDTO> updateUser(UserDTO userDTO) {
		Optional<User> id = userRepo.findById(userDTO.getUserId());
		if (id.isPresent()) {
			userDTO.setUserName(userDTO.getUserName());
			userDTO.setUserpassword(userDTO.getUserpassword());
			userDTO.setAddress(userDTO.getAddress());
			userDTO.setCity(userDTO.getCity());
			userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(id.get()), HttpStatus.CREATED);
		}
		//User updatedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<UserDTO> fetchUserDetailById(Integer userId) {
		Optional<User> id = userRepo.findById(userId);
		if (id.isPresent()) 
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(id.get()), HttpStatus.CREATED);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}	

}
