package com.microservices.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
	
	private Integer id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private long price;
	private Integer restaurantId;
	private Integer quantity;

}
