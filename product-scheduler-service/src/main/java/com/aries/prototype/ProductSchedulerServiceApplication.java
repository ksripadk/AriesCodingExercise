package com.aries.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.aries.prototype.controller", "com.aries.prototype.model", "com.aries.prototype.service"})
public class ProductSchedulerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSchedulerServiceApplication.class, args);
	}

}
