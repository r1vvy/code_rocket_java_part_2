package com.coderocket.sportscomp.in.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.dto.CompetitionContextHolder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReadCompetitionAction implements MenuActionWithSubActions {
    private final UserInput userInput;
    private final CompetitionService competitionService;

    @Autowired()
    @Qualifier("competitionContextHolder")
    private final CompetitionContextHolder contextHolder;

    @Autowired
    @Qualifier("competitionSubActions")
    private final List<MenuAction> competitionSubActions;


    @Override
    public String getName() {
        return "Read competition";
    }

    @Override
    public List<MenuAction> getSubActions() {
        return competitionSubActions;
    }

    @Override
    public void execute() {
        var request = userInput.getReadCompetitionByIdRequest();
        var competition = competitionService.getCompetitionById(request.getId());

        System.out.println("Competition: " + competition);

        contextHolder.setChosenCompetition(competition);
    }
}
