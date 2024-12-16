package com.microservices.restaurantListing.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.restaurantListing.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long>{
	
	public Optional<Restaurant> findById(long id);

}
