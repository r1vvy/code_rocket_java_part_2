package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

public interface AddPlayerToCompetitionPort {

    void addPlayerToCompetition(Player player, Integer competitionId);
}
