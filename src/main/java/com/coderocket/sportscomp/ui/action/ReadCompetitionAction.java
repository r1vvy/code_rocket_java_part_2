package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.ui.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReadCompetitionAction implements MenuActionWithSubActions {
    private final UserInput userInput;
    private final CompetitionService competitionService;
    private final List<MenuAction> subActions;

    @Override
    public String getName() {
        return "Read competition";
    }

    @Override
    public List<MenuAction> getSubActions() {
        return subActions;
    }

    @Override
    public void execute() {
        var request = userInput.getReadCompetitionByIdRequest();
        var competition = competitionService.getCompetitionById(request.getId());
        System.out.println("Competition: " + competition);

    }
}
