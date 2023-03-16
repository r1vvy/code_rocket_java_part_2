package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.PlayerInCompetition;

public interface GetPlayerFromCompetitionUseCase {
    PlayerInCompetition getPlayerByIdFromCompetitionById(Integer playerId, Integer competitionId);
}
