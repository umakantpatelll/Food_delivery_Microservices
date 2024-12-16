package com.microservices.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromFE;
import com.microservices.order.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
		OrderDTO saveOrderInDB = orderService.saveOrderInDB(orderDetails);
		return new ResponseEntity<>(saveOrderInDB, HttpStatus.CREATED);		
	}
	
	

}
