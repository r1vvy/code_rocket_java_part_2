package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.UpdateCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCompetitionAdapter implements UpdateCompetitionPort {
    private final CompetitionRepository competitionRepository;
    private final CompetitionDomainToCompetitionEntityConverter competitionDomainToCompetitionEntityConverter;
    private final CompetitionEntityToCompetitionDomainConverter competitionEntityToCompetitionDomainConverter;

    @Override
    @Transactional
    public Competition update(Competition updatedCompetition, Integer id) {
        var entity = competitionDomainToCompetitionEntityConverter.convert(updatedCompetition);
        entity.setId(id);

        var savedEntity = competitionRepository.save(entity);

        return competitionEntityToCompetitionDomainConverter.convert(savedEntity);
    }
}
