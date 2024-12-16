package com.microservices.userInformation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.userInformation.dto.UserDTO;
import com.microservices.userInformation.entity.User;


@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDTOToUser(UserDTO userDTO);
	
	UserDTO mapUserToUserDTO(User user);

}
