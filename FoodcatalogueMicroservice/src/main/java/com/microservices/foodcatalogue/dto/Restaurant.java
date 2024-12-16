package com.microservices.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	private int id;
	private String name;
	private String address;
	private String city;
	private String restaurantDescription;

}
