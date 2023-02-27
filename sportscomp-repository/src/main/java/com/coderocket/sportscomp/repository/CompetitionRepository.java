package com.coderocket.sportscomp.repository;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionRepository {

    void save(Competition competition);

    void delete(Competition competition);

    List<Competition> findAllCompetitions();

    // TODO
    Optional<Competition> findById(Integer id);
}
