package com.equilibria.api_gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaysApplication.class, args);
		System.out.println("==========================================================================");
		System.out.println("Sucesss - API GATEWAY !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("==========================================================================");
	}

}
