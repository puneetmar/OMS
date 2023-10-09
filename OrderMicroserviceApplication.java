package com.oms.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroserviceApplication.class, args);
	}


	@Bean
	public RestTemplate injectTemplate() {
		return new RestTemplate();
	}

	 @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate();
    }

}
