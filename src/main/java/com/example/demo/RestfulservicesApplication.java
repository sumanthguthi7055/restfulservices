package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@ComponentScan({ "com.example.demo.*" })
@EnableJpaRepositories
public class RestfulservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulservicesApplication.class, args);
	}

}
