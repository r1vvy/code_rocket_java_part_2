package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.FindCompetitionByIdPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindCompetitionByIdAdapter implements FindCompetitionByIdPort {
    private final CompetitionRepository repository;
    private final CompetitionEntityToCompetitionDomainConverter competitionEntityToCompetitionDomainConverter;

    @Override
    @Transactional
    public Optional<Competition> findById(Integer id) {

        return repository.findById(id)
                .map(competitionEntityToCompetitionDomainConverter::convert);
    }
}
