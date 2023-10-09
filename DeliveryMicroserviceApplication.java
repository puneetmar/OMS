package com.oms.delivery_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeliveryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate injectTemplate() {
		return new RestTemplate();
	}
	
}