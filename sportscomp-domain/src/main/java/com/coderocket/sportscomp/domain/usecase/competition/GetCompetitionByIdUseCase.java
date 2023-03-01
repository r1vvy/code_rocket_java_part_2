package com.coderocket.sportscomp.domain.usecase.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface GetCompetitionByIdUseCase {

    Competition getCompetition(Integer id);
}
