package com.microservices.userInformation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.userInformation.dto.UserDTO;

@Service
public interface UserService {

	UserDTO addUser(UserDTO userDTO);

	List<UserDTO> getAllUsers();

	ResponseEntity<UserDTO> updateUser(UserDTO userDTO);

	ResponseEntity<UserDTO> fetchUserDetailById(Integer userId);

}
