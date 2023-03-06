package com.coderocket.sportscomp.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.coderocket.sportscomp")
@EnableJpaRepositories(basePackages = "com.coderocket.sportscomp.repository")
@EntityScan(basePackages = "com.coderocket.sportscomp.repository")
public class SportsCompApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.coderocket.sportscomp");

		SpringApplication.run(SportsCompApplication.class);
	}
}
