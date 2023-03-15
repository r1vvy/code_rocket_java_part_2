package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.competitionPlayer;

public interface AddPlayerToCompetitionPort {

    void addPlayerToCompetition(competitionPlayer competitionPlayer, Integer competitionId);
}
