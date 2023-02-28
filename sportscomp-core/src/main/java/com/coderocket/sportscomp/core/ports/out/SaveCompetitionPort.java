package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Competition;

public interface SaveCompetitionPort {

    void save(Competition competition);
}
