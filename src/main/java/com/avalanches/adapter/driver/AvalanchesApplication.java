//package com.avalanches.driver.avalanchesapp;
package com.avalanches.adapter.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.avalanches"})
public class AvalanchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvalanchesApplication.class, args);
	}

}
