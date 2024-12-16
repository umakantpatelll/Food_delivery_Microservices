package com.microservices.userInformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private int userId;
	private String userName;
	private String userpassword;
	private String address;
	private String city;
	

}
