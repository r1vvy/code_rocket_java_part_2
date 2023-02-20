package com.coderocket.sportscomp;


import com.coderocket.sportscomp.ui.UserMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsCompApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.coderocket.sportscomp");
		var userMenu = applicationContext.getBean(UserMenu.class);
		userMenu.startMenu();
	}

}
