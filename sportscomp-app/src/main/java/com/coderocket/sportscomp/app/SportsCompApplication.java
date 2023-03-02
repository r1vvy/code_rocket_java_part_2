package com.coderocket.sportscomp.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.coderocket.sportscomp", exclude = HibernateJpaAutoConfiguration.class)
public class SportsCompApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.coderocket.sportscomp");

		SpringApplication.run(SportsCompApplication.class);
	}
}
