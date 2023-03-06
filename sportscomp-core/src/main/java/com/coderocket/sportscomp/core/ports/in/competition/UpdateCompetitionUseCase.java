package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface UpdateCompetitionUseCase {

    Competition update(Competition competition, Integer id);
}
