package com.equlibria.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class ServiceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceregistryApplication.class, args);
		System.out.println("===============================================================================");
		System.out.println("Sucesss - Service Registry !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("===============================================================================");
	}

}
