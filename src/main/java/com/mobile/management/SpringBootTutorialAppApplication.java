package com.mobile.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.rest.api"})
public class SpringBootTutorialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialAppApplication.class, args);
	}

}
