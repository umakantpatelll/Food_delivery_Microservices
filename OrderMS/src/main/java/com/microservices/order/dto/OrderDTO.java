package com.microservices.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	private Integer orderId;
	private List<FoodItemDTO> foodItemList;
	private Restaurant restaurant;
	private UserDTO userDTO;

}
