package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.SaveCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCompetitionAdapter implements SaveCompetitionPort {

    private final CompetitionRepository repository;
    private final CompetitionDomainToCompetitionEntityConverter competitionDomainToCompetitionEntityConverter;
    private final CompetitionEntityToCompetitionDomainConverter competitionEntityToCompetitionDomainConverter;

    @Override
    public Competition save(Competition competition) {
        var entity = competitionDomainToCompetitionEntityConverter.convert(competition);
        var savedEntity = repository.save(entity);

        return competitionEntityToCompetitionDomainConverter.convert(savedEntity);
    }
}
