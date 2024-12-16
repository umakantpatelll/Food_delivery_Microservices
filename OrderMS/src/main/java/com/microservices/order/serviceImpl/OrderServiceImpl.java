package com.microservices.order.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromFE;
import com.microservices.order.dto.UserDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.mapper.OrderMapper;
import com.microservices.order.repo.OrderRepo;
import com.microservices.order.services.OrderService;
import com.microservices.order.services.SequenceGenerator;

@Component
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {
		long newOrderID = sequenceGenerator.generateNextOrderId();
		
		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		
		Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO);
		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}	

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		UserDTO userDTO = restTemplate.getForObject("http://localhost:9093/user/fetchUserById/"+userId, UserDTO.class);
		return userDTO;
	}	
	
	
	
	

}
