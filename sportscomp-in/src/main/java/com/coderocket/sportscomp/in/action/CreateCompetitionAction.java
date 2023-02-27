package com.coderocket.sportscomp.in.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.converter.CreateCompetitionInRequestToDomainConverter;
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
