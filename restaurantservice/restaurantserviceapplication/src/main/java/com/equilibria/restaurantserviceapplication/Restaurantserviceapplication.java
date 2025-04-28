package com.equilibria.restaurantserviceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Restaurantserviceapplication {

	public static void main(String[] args) {
		SpringApplication.run(Restaurantserviceapplication.class, args);
		System.out.println("================================================================================");
		System.out.println("Sucesss - RESTAURANT SERVICE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("================================================================================");
	}

}
