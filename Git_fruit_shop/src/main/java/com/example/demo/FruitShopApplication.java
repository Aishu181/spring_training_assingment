package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("module-service")
public class FruitShopApplication {

	 
	 
	public static void main(String[] args) {
		SpringApplication.run(FruitShopApplication.class, args);
	}

}
