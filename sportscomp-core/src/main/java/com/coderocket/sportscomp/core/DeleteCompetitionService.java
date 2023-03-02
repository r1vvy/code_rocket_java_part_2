package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.competition.DeleteCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.competition.DeleteCompetitionPort;
import com.coderocket.sportscomp.core.ports.out.competition.FindCompetitionByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCompetitionService implements DeleteCompetitionUseCase {

    private final DeleteCompetitionPort deleteCompetitionPort;
    private final FindCompetitionByIdPort findCompetitionByIdPort;

    @Override
    public void deleteCompetitionById(Integer id) {
        var competition = findCompetitionByIdPort.findById(id);

        deleteCompetitionPort.delete(competition.get());
    }
}
