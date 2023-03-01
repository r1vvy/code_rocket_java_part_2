package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.out.competition.SaveCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.domain.usecase.competition.SaveCompetitionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCompetitionService implements SaveCompetitionUseCase {

    private final SaveCompetitionPort port;

    @Override
    public void saveCompetition(Competition competition) {
        port.save(competition);
    }
}
