package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.DeleteCompetitionByIdPort;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCompetitionAdapter implements DeleteCompetitionByIdPort {
    private final CompetitionRepository competitionRepository;
    private final CompetitionPlayerRepository competitionPlayerRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        competitionPlayerRepository.deleteAllByCompetitionEntityId(id);

        competitionRepository.deleteById(id);
    }
}
