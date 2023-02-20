package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.domain.Competition;

import java.util.stream.Stream;

public interface CompetitionRepository {

    void save(Competition competition);

    Stream<Competition> getAllCompetitions();
}
