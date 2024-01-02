package com.example.Storeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class StoreProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProjectApplication.class, args);
	}

}
