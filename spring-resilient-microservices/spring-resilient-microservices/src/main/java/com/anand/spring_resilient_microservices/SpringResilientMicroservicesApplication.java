package com.anand.spring_resilient_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringResilientMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringResilientMicroservicesApplication.class, args);
	}

}
