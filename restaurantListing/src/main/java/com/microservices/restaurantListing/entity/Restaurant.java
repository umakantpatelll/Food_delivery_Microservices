package com.microservices.restaurantListing.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String city;
	private String restaurantDescription;
	
	

}
