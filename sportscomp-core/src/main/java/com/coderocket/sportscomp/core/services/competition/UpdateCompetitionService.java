package com.coderocket.sportscomp.core.services.competition;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.in.competition.UpdateCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.competition.FindCompetitionByIdPort;
import com.coderocket.sportscomp.core.ports.out.competition.UpdateCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCompetitionService implements UpdateCompetitionUseCase {
    private final UpdateCompetitionPort updateCompetitionPort;
    private final FindCompetitionByIdPort findCompetitionByIdPort;

    @Override
    public Competition update(Competition competition, Integer id) {
        findCompetitionByIdPort.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No competition found with id = " + id));

        return updateCompetitionPort.update(competition, id);
    }
}
