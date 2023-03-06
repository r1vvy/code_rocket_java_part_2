package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.FindAllCompetitionsPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class FindAllCompetitionsAdapter implements FindAllCompetitionsPort {
    private final CompetitionRepository repository;

    CompetitionEntityToCompetitionDomainConverter converter;

    @Override
    public List<Competition> findAll() {

        Iterable<CompetitionEntity> iterable = repository.findAll();

        return StreamSupport.stream(iterable.spliterator(), false)
                .map(entity -> converter.convert(entity))
                .collect(Collectors.toList());
    }
}
