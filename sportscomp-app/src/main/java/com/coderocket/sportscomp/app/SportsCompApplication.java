package com.coderocket.sportscomp.app;


import com.coderocket.sportscomp.in.UserMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsCompApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.coderocket.sportscomp");
		var userMenu = applicationContext.getBean(UserMenu.class);
		userMenu.startMenu();
	}

}
