package com.coderocket.sportscomp.core.ports.out.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface UpdateCompetitionPort {

    Competition update(Competition competition, Integer id);
}
