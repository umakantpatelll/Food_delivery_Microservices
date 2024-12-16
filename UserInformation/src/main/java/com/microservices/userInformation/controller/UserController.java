package com.microservices.userInformation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userInformation.dto.UserDTO;
import com.microservices.userInformation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
		UserDTO savedUser = userService.addUser(userDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
		ResponseEntity<UserDTO> updatedUser = userService.updateUser(userDTO);
		return updatedUser;
	}
	
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId){
		ResponseEntity<UserDTO> updatedUser = userService.fetchUserDetailById(userId);
		return updatedUser;
	}

}
