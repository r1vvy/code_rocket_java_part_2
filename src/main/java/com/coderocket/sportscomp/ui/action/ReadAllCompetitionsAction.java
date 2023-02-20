package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
        System.out.println(competitions.stream().map(Objects::toString));
    }
}
