package com.arthursong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@PropertySource("classpath:application-dev.yml")
public class SpringBootWithMultiEnvironmentsApplication {

	@GetMapping("/")
	public String index(){
		return "app is running !";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMultiEnvironmentsApplication.class, args);
	}
}
