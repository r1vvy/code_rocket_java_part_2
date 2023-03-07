package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.Player;

public interface AddPlayerToCompetitionUseCase {

    void addPlayerToCompetitionByCompetitionId(Player player, Integer competitionId);
}
