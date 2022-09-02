package com.windstorm.awsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories("com.windstorm.awsdemo.rds.repo")
@EnableMongoRepositories("com.windstorm.awsdemo.nosql.repo")
@EntityScan(basePackages = {"com.windstorm.awsdemo.rds.model", "com.windstorm.awsdemo.nosql.model"})
@SpringBootApplication
public class AwsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsdemoApplication.class, args);
	}

}
