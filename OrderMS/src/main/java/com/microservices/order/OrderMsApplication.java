package com.microservices.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import com.mongodb.client.MongoClients;

@SpringBootApplication
//@EnableMongoRepositories
public class OrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}
	
	/*
	 * @Bean public MongoTemplate mongoTemplate() { return new
	 * MongoTemplate(MongoClients.create("mongodb://localhost:27017"),
	 * "order_ms_db"); }
	 */
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
