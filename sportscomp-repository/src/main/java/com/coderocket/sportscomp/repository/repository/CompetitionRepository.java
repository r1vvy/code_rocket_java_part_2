package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionRepository {

    Competition save(Competition competition);

    void delete(Competition competition);

    Competition update(Competition updatedCompetition, Integer id);

    List<Competition> findAllCompetitions();

    // TODO
    Optional<Competition> findById(Integer id);
}
