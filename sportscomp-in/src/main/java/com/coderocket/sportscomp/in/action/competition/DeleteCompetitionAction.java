package com.coderocket.sportscomp.in.action.competition;


import com.coderocket.sportscomp.core.ports.in.competition.DeleteCompetitionUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.dto.CompetitionContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("deleteCompetitionAction")
@RequiredArgsConstructor
public class DeleteCompetitionAction implements MenuAction {
    private final UserInput userInput;

    private final DeleteCompetitionUseCase deleteCompetition;
    @Autowired
    @Qualifier("competitionContextHolder")
    private final CompetitionContextHolder contextHolder;

    @Override
    public String getName() {
        return "Delete competition";
    }

    @Override
    public void execute() {
        var request = userInput.getDeleteCompetitionRequest();

        deleteCompetition.deleteCompetition(request.getCompetition());
        contextHolder.clearChosenCompetition();
    }
}
