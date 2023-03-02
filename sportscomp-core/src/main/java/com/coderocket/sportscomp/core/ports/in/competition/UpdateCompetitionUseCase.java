package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface UpdateCompetitionUseCase {

    Competition updateCompetition(Competition competition, Integer id);
}
