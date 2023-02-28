package com.coderocket.sportscomp.in.action.competition;

import com.coderocket.sportscomp.core.ports.in.competition.GetCompetitionByIdUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.action.MenuActionWithSubActions;
import com.coderocket.sportscomp.in.dto.CompetitionContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("readCompetitionAction")
@RequiredArgsConstructor
public class ReadCompetitionAction implements MenuActionWithSubActions {
    private final UserInput userInput;
    private final GetCompetitionByIdUseCase getCompetitionByIdUseCase;
    @Autowired()
    @Qualifier("competitionContextHolder")
    private CompetitionContextHolder contextHolder;

    @Autowired
    @Qualifier("competitionSubActions")
    private List<MenuAction> competitionSubActions;


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
        var competition = getCompetitionByIdUseCase.getCompetition(request.getId());

        System.out.println("Competition: " + competition);

        contextHolder.setChosenCompetition(competition);
    }
}
