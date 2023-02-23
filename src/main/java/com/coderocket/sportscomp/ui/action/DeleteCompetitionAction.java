package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.holder.ChosenCompetitionHolder;
import com.coderocket.sportscomp.ui.UserInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCompetitionAction implements MenuAction{
    private final UserInput userInput;
    private final CompetitionService competitionService;

    @Override
    public String getName() {
        return "Delete competition";
    }

    @Override
    public void execute() {
        var request = userInput.getDeleteCompetitionRequest();

        competitionService.deleteCompetition(request.getCompetition());
        ChosenCompetitionHolder.clearChosenCompetition();
    }
}
