package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionRepository {

    void save(Competition competition);

    List<Competition> findAllCompetitions();

    // TODO
    Optional<Competition> findById(Integer id);
}
