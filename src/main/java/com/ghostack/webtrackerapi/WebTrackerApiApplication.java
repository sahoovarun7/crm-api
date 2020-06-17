package com.ghostack.webtrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WebTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTrackerApiApplication.class, args);
	}

}
