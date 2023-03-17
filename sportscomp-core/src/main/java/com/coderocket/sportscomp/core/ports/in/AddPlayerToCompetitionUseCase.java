package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.CompetitionPlayer;

public interface AddPlayerToCompetitionUseCase {

    PlayerInCompetition addPlayerToCompetitionByCompetitionId(CompetitionPlayer competitionPlayer, Integer competitionId);
}
