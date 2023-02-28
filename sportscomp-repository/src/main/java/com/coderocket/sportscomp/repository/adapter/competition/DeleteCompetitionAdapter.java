package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.DeleteCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeleteCompetitionAdapter implements DeleteCompetitionPort {

    private final CompetitionRepository competitionRepository;

    @Override
    public void delete(Competition competition) {
        competitionRepository.delete(competition);
    }
}
