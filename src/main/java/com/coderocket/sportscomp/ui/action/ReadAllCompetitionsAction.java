package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.exceptions.NoElementFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
        var competitions = competitionService.getAllCompetitionsAsArrayList();
        try {
            validateAnyCompetitionExistence(competitions);
            printAllCompetitions(competitions);
        } catch(NoElementFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printAllCompetitions(ArrayList<Competition> competitions) {
        for (int i = 0; i < competitions.size(); i++) {
            System.out.println(i + ". " + competitions.get(i));
        }
    }
    // TODO: Add this as validation "AnyObjectExistenceValidation" to reuse for ViewAllPlayersAction.
    private static void validateAnyCompetitionExistence(ArrayList<Competition> competitions) {
        if(competitions.isEmpty()) {
            throw new NoElementFoundException("No competition found");
        }
    }
}
