package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.CompetitionPlayer;

public interface AddPlayerToCompetitionPort {

    PlayerInCompetition addPlayerToCompetition(CompetitionPlayer competitionPlayer, Integer competitionId);
}
