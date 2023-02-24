package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.dto.CompetitionContextHolder;
import com.coderocket.sportscomp.ui.UserInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCompetitionAction implements MenuAction{
    private final UserInput userInput;
    private final CompetitionService competitionService;

    @Autowired()
    @Qualifier("competitionContextHolder")
    private final CompetitionContextHolder contextHolder;

    @Override
    public String getName() {
        return "Delete competition";
    }

    @Override
    public void execute() {
        var request = userInput.getDeleteCompetitionRequest();

        competitionService.deleteCompetition(request.getCompetition());

        contextHolder.clearChosenCompetition();
    }
}
