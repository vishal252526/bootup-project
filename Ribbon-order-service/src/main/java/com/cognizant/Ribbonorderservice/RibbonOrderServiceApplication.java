package com.cognizant.Ribbonorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cognizant.Ribbonorderservice")
public class RibbonOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonOrderServiceApplication.class, args);
	}

}
