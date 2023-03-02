package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.UpdateCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class UpdateCompetitionAdapter implements UpdateCompetitionPort {
    private final CompetitionRepository competitionRepository;

    @Override
    public Competition update(Competition updatedCompetition, Integer id) {
        return competitionRepository.update(updatedCompetition, id);
    }
}
