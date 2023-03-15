package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.competitionPlayer;

public interface AddPlayerToCompetitionUseCase {

    void addPlayerToCompetitionByCompetitionId(competitionPlayer competitionPlayer, Integer competitionId);
}
