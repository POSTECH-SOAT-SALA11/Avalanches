package com.avalanches.frameworksanddrivers.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.avalanches")
public class AvalanchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvalanchesApplication.class, args);
	}

}
