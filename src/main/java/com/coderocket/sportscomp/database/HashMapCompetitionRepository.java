package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.database.converter.CompetitionEntityToCompetitionDomainCoverter;
import com.coderocket.sportscomp.domain.Competition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class HashMapCompetitionRepository implements CompetitionRepository{
    private static Integer COMP_SEQUENCE = 1;
    private Map<Integer, CompetitionEntity>  repo = new HashMap<>();
    private final CompetitionDomainToCompetitionEntityConverter domainToEntityConverter;
    private final CompetitionEntityToCompetitionDomainCoverter entityToDomainCoverter;
    @Override
    public void save(Competition competition) {
        CompetitionEntity entity = domainToEntityConverter.convert(competition, ++COMP_SEQUENCE);
        repo.put(entity.getId(), entity);
    }

    @Override
    public Stream<Competition> getAllCompetitions() {
        return repo.values()
                .stream()
                .map(entityToDomainCoverter::convert);
    }
}
