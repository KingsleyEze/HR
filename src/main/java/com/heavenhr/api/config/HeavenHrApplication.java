package com.heavenhr.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.heavenhr.api.repositories")
@EntityScan("com.heavenhr.api.data.entities")
@SpringBootApplication
@ComponentScan("com.heavenhr.api")
@EnableAutoConfiguration
public class HeavenHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeavenHrApplication.class, args);
	}
}
