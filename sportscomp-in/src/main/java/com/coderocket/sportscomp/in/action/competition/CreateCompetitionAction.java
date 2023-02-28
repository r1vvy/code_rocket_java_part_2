package com.coderocket.sportscomp.in.action.competition;

import com.coderocket.sportscomp.core.ports.in.competition.SaveCompetitionUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.converter.CreateCompetitionInRequestToDomainConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("createCompetitionAction")
@RequiredArgsConstructor
public class CreateCompetitionAction implements MenuAction {
    private final UserInput userInput;
    private final CreateCompetitionInRequestToDomainConverter converter;
    private final SaveCompetitionUseCase saveCompetitionUseCase;

    @Override
    public String getName() {
        return "Create competition";
    }

    @Override
    public void execute() {
        var request = userInput.getCreateCompetitionRequest();
        var competition = converter.convert(request);

        saveCompetitionUseCase.saveCompetition(competition);
    }
}
