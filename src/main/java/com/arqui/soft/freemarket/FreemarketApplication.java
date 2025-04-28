package com.arqui.soft.freemarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FreemarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreemarketApplication.class, args);
	}

}
