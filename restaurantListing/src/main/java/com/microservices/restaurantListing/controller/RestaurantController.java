package com.microservices.restaurantListing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.restaurantListing.dto.RestaurantDTO;
import com.microservices.restaurantListing.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
		List<RestaurantDTO> allRestaurants= restaurantService.findAllRestaurants();
		return new ResponseEntity<List<RestaurantDTO>>(allRestaurants, HttpStatus.OK);
	}
	
	@PostMapping("/addRestaurants")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		RestaurantDTO addedRestaurant = restaurantService.saveRestaurant(restaurantDTO);
		return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		ResponseEntity<RestaurantDTO> updateRestaurant = restaurantService.updateRestaurant(restaurantDTO);
		return updateRestaurant;
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id){
		ResponseEntity<RestaurantDTO> fetchRestaurant = restaurantService.fetchRestaurantById(id);
		return fetchRestaurant;
	}

}
