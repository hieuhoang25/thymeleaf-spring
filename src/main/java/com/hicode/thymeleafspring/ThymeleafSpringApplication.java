package com.hicode.thymeleafspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafSpringApplication {

	public static void main(String[] args) {
		String buildTime = System.getProperty("buildTime");
		if (buildTime != null) {
			System.setProperty("build.time", buildTime);
		}
		SpringApplication.run(ThymeleafSpringApplication.class, args);
	}

}
