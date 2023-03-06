package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.DeleteCompetitionByIdPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCompetitionAdapter implements DeleteCompetitionByIdPort {
    private final CompetitionRepository competitionRepository;

    @Override
    public void deleteById(Integer id) {

        competitionRepository.deleteById(id);
    }
}
