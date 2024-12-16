package com.microservices.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.microservices.foodcatalogue.external.services")
@EnableDiscoveryClient
public class FoodcatalogueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcatalogueMicroserviceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
