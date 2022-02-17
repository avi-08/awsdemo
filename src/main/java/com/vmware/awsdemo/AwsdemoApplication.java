package com.vmware.awsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories("com.vmware.awsdemo.rds.repo")
@EnableMongoRepositories("com.vmware.awsdemo.nosql.repo")
@EntityScan(basePackages = {"com.vmware.awsdemo.rds.model", "com.vmware.awsdemo.nosql.model"})
@SpringBootApplication
public class AwsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsdemoApplication.class, args);
	}

}
