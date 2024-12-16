package com.microservices.restaurantListing.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.microservices.restaurantListing.dto.RestaurantDTO;
import com.microservices.restaurantListing.entity.Restaurant;
import com.microservices.restaurantListing.mapper.RestaurantMapper;
import com.microservices.restaurantListing.repo.RestaurantRepo;
import com.microservices.restaurantListing.service.RestaurantService;

@Component
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> findAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepo.findAll();
		
		//map it to list of DTO's with the help of mapper because we are getting entity by findAll() method so we have to convert it to the DTO using Mapper
		List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		return restaurantDTOList;
	}

	@Override
	public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant saveRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(saveRestaurant);
	}
	
	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
	Optional<Restaurant> restaurant = restaurantRepo.findById(id);
	if(restaurant.isPresent()) {
		return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
	}
	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	

	@Override
	public ResponseEntity<RestaurantDTO> updateRestaurant(RestaurantDTO restaurantDTO) {
		Optional<Restaurant> restaurantOpt = restaurantRepo.findById(restaurantDTO.getId());
		if(restaurantOpt.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		restaurantDTO.setName(restaurantDTO.getName());
		restaurantDTO.setAddress(restaurantDTO.getAddress());
		restaurantDTO.setCity(restaurantDTO.getCity());
		restaurantDTO.setRestaurantDescription(restaurantDTO.getRestaurantDescription());
		restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantOpt.get()), HttpStatus.OK);
	}
	
	

}
