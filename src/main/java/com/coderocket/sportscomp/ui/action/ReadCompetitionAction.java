package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.exceptions.NotImplementedException;
import com.coderocket.sportscomp.ui.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReadCompetitionAction implements MenuAction {
    private final UserInput userInput;
    private final CompetitionService competitionService;
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void execute() {
        throw new NotImplementedException("Not implemented yet!");
    }
}
