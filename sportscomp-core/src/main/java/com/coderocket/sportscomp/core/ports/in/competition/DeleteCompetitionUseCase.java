package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface DeleteCompetitionUseCase {

    void deleteCompetition(Competition competition);
}
