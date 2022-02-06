package com.scode;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cassandra", version = "1.0",
		description = "API for Stock Quotes"))
public class QuoteServiceApplication {

	public static void main(String[] args) {
		log.info("Stock Service Initiated!");
		SpringApplication.run(QuoteServiceApplication.class, args);
	}

}
