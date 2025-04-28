package com.equilibria.foodverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodverseApplication.class, args);
		System.out.println("=========================================================================");
		System.out.println("Sucesss - FOOD VERSE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("=========================================================================");
	}

}
