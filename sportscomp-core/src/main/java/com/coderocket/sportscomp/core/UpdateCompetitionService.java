package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.competition.UpdateCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.competition.UpdateCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCompetitionService implements UpdateCompetitionUseCase {
    private final UpdateCompetitionPort updateCompetitionPort;
    @Override
    public Competition updateCompetition(Competition updatedCompetition, Integer id) {
        return updateCompetitionPort.update(updatedCompetition, id);
    }
}
