package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.domain.Competition;

public interface CompetitionRepository {

    void save(Competition competition);
}
