package com.microservices.userInformation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.userInformation.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
