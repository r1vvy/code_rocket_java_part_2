package com.coderocket.sportscomp.core.services.competition;

import com.coderocket.sportscomp.core.ports.in.competition.DeleteCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.competition.DeleteCompetitionByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCompetitionService implements DeleteCompetitionUseCase {

    private final DeleteCompetitionByIdPort deleteCompetitionByIdPortPort;

    @Override
    public void deleteCompetitionById(Integer id) {
        deleteCompetitionByIdPortPort.deleteById(id);
    }
}
