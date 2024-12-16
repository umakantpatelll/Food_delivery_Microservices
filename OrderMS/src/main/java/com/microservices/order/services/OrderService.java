package com.microservices.order.services;

import org.springframework.stereotype.Service;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromFE;

@Service
public interface OrderService {

	OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails);

}
