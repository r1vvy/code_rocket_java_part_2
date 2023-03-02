package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface GetCompetitionByIdUseCase {

    Competition getCompetition(Integer id);
}
