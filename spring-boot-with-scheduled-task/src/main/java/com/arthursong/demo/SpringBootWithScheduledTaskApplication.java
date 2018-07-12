package com.arthursong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWithScheduledTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithScheduledTaskApplication.class, args);
	}
}
