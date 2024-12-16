package com.microservices.restaurantListing.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.restaurantListing.dto.RestaurantDTO;

@Service
public interface RestaurantService {

	public List<RestaurantDTO> findAllRestaurants();

	public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO);

	public ResponseEntity<RestaurantDTO> updateRestaurant(RestaurantDTO restaurantDTO);

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id);

}
