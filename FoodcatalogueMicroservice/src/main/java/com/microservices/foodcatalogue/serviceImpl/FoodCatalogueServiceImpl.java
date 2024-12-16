package com.microservices.foodcatalogue.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservices.foodcatalogue.dto.FoodCataloguePage;
import com.microservices.foodcatalogue.dto.FoodItemDTO;
import com.microservices.foodcatalogue.dto.Restaurant;
import com.microservices.foodcatalogue.entity.FoodItem;
import com.microservices.foodcatalogue.mapper.FoodItemMapper;
import com.microservices.foodcatalogue.repo.FoodItemRepo;
import com.microservices.foodcatalogue.service.FoodCatalogueService;

@Component
public class FoodCatalogueServiceImpl implements FoodCatalogueService{

	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	/*
	 * @Autowired RestaurantServiceClient restaurantServiceClient;
	 */

	@Override
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem saveFoodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(saveFoodItem);
	}

	@Override
	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurentId) {
		//food item list
		List<FoodItem> foodItemList = fetchFoodItemList(restaurentId);
		//restaurantDetails
		System.out.println("Above fetchRestaurantDetailsFromRestaurantMS ------------------------- ");
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurentId);
		System.out.println("Restaurent name in fetchFoodCataloguePageDetails API : " +restaurant.getName());

		return createFoodCataloguePage(foodItemList, restaurant);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurentId) {
		return foodItemRepo.findByRestaurantId(restaurentId);

	}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurentId) {
		String url = "http://localhost:9091/restaurant/fetchById/"+restaurentId;
		return restTemplate.getForObject(url, Restaurant.class);
		//Restaurant restaurant = restaurantServiceClient.getRestaurantById(restaurentId);
		//return null;
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemsList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;

	}

}
