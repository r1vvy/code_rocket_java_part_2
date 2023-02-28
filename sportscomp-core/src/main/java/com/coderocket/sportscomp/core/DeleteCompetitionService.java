package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.competition.DeleteCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.DeleteCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCompetitionService implements DeleteCompetitionUseCase {

    private final DeleteCompetitionPort port;

    @Override
    public void deleteCompetition(Competition competition) {

        port.delete(competition);
    }
}