package com.coderocket.sportscomp.app;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsCompApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.coderocket.sportscomp");
	}

}
