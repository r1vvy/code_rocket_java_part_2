package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReadAllCompetitionsAction implements MenuAction{
    private final CompetitionService competitionService;

    @Override
    public String getName() {
        return "View all competitions";
    }

    @Override
    public void execute() {
        var competitions = competitionService.getAllCompetitions();
        printAllCompetitions(competitions);
    }

    private static void printAllCompetitions(List<Competition> competitions) {
        competitions.forEach(competition -> System.out.println(competition));
    }
}
