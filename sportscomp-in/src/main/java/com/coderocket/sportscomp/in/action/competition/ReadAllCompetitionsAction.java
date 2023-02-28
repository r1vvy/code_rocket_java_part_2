package com.coderocket.sportscomp.in.action.competition;

import com.coderocket.sportscomp.core.ports.in.competition.GetAllCompetitionsUseCase;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.action.MenuAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("readAllCompetitionsAction")
@AllArgsConstructor
public class ReadAllCompetitionsAction implements MenuAction {
    private final GetAllCompetitionsUseCase getAllCompetitionsUseCase;
    @Override
    public String getName() {
        return "View all competitions";
    }

    @Override
    public void execute() {
        var competitions = getAllCompetitionsUseCase.getAllCompetitions();
        printAllCompetitions(competitions);
    }

    private static void printAllCompetitions(List<Competition> competitions) {
        competitions.forEach(competition -> System.out.println(competition));
    }
}
