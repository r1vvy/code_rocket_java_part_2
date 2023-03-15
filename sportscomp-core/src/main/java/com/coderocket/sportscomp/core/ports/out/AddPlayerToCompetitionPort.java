package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.competitionPlayer;

public interface AddPlayerToCompetitionPort {

    PlayerInCompetition addPlayerToCompetition(competitionPlayer competitionPlayer, Integer competitionId);
}
