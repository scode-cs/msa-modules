package com.scode;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

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
	
	@Bean
	public Stock getQ() {
		try {
			Stock s = YahooFinance.get("AXISBANK.NS");
			System.out.println(s.getName() + ": " + s.getQuote().getPrice());
			
			return s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
