package com.eateryease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.eateryease"})
public class EateryEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EateryEaseApplication.class, args);
	}

}
