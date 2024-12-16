package com.microservices.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.microservices.order.dto.FoodItemDTO;
import com.microservices.order.dto.Restaurant;
import com.microservices.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
	
	private long orderId;
	private List<FoodItemDTO> foodItemList;
	private Restaurant restaurant;
	private UserDTO userDTO;

}
