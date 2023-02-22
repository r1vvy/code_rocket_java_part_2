package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.database.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.domain.Competition;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class HashMapCompetitionRepository implements CompetitionRepository{
    private static Integer COMP_SEQUENCE = 1;
    private Map<Integer, CompetitionEntity>  repo = new HashMap<>();
    private final CompetitionDomainToCompetitionEntityConverter domainToEntityConverter;
    private final CompetitionEntityToCompetitionDomainConverter entityToDomainConverter;
    @Override
    public void save(Competition competition) {
        CompetitionEntity entity = domainToEntityConverter.convert(competition);
        entity.setId(COMP_SEQUENCE++);
        repo.put(entity.getId(), entity);
    }

    @Override
    public List<Competition> findAllCompetitions() {
        return repo.values()
                .stream()
                .map(entityToDomainConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Competition> findById(Integer id) {
        return Optional.ofNullable(repo.get(id))
                .map(entityToDomainConverter::convert);
    }
}
