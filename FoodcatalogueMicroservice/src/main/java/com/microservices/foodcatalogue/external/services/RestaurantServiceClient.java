/*
 * package com.microservices.foodcatalogue.external.services;
 * 
 * import org.springframework.cloud.openfeign.FeignClient; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable;
 * 
 * import com.microservices.foodcatalogue.dto.Restaurant;
 * 
 * @FeignClient(name = "restaurant-service") public interface
 * RestaurantServiceClient {
 * 
 * @GetMapping("/restaurant/fetchById/{id}") public Restaurant
 * getRestaurantById(@PathVariable("id") Integer id); }
 */