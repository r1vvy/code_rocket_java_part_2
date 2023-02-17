package com.coderocket.sportscomp;


import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.ui.UserInput;
import com.coderocket.sportscomp.ui.UserMenu;
import com.coderocket.sportscomp.ui.action.MenuAction;
import com.coderocket.sportscomp.ui.action.ReadAllCompetitionsAction;

import java.util.List;

public class SportsCompApplication {

	public static void main(String[] args) {
		CompetitionService competitionService = new CompetitionService();

		List<MenuAction> actionList = List.of(
				new ReadAllCompetitionsAction(competitionService)
		);
		UserInput userInput = new UserInput();
		UserMenu userMenu = new UserMenu(userInput, actionList);

		userMenu.startMenu();
	}

}
