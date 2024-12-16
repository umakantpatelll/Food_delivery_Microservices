package com.microservices.foodcatalogue.dto;

import java.util.List;

import com.microservices.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

	private List<FoodItem> foodItemsList;
	private Restaurant restaurant;


}
