package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.ui.UserInput;
import com.coderocket.sportscomp.ui.converter.CreateCompetitionInRequestToDomainConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCompetitionAction implements MenuAction {
    private final UserInput userInput;
    private final CompetitionService competitionService;
    private final CreateCompetitionInRequestToDomainConverter converter;

    @Override
    public String getName() {
        return "Create competition";
    }

    @Override
    public void execute() {
        var request = userInput.getCompetitionCreationRequest();
        var competition = converter.convert(request);

        competitionService.createCompetition(competition);
    }
}
