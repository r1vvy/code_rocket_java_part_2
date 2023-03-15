package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.competitionPlayer;

public interface AddPlayerToCompetitionUseCase {

    PlayerInCompetition addPlayerToCompetitionByCompetitionId(competitionPlayer competitionPlayer, Integer competitionId);
}
