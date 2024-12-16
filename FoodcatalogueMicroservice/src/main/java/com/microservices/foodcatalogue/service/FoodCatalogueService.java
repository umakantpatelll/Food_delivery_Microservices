package com.microservices.foodcatalogue.service;

import org.springframework.stereotype.Service;

import com.microservices.foodcatalogue.dto.FoodCataloguePage;
import com.microservices.foodcatalogue.dto.FoodItemDTO;

@Service
public interface FoodCatalogueService {

	FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO);

	FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurentId);

}
