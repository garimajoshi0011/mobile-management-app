package com.mobile.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.mobile.management"})
public class UserMobileManagementApp {

	public static void main(String[] args) {
		SpringApplication.run(UserMobileManagementApp.class, args);
	}

}
