package com.sparta.airbnb_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AirBnBCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirBnBCloneApplication.class, args);
	}

}