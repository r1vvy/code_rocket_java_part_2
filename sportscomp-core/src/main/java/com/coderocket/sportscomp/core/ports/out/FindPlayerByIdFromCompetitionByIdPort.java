package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.PlayerInCompetition;

public interface FindPlayerByIdFromCompetitionByIdPort {
    PlayerInCompetition findByPlayerIdFromCompetitionById(Integer playerId, Integer competitionId);
}
