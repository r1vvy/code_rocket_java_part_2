package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.holder.ChosenCompetitionHolder;
import com.coderocket.sportscomp.ui.UserInput;
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
        ChosenCompetitionHolder.setChosenCompetition(competition);
    }
}
