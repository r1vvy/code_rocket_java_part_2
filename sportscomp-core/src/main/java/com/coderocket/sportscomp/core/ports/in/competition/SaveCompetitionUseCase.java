package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface SaveCompetitionUseCase {

    Competition saveCompetition(Competition competition);
}
