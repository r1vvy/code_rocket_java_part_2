package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;

public class ReadAllCompetitionsAction implements MenuAction{
    private final CompetitionService competitionService;


    public ReadAllCompetitionsAction(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @Override
    public String getName() {
        return "Read competitions";
    }

    @Override
    public void execute() {
        competitionService.readAllCompetitions();
    }
}
