package com.flys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterRecoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterRecoveryServiceApplication.class, args);
	}

}
