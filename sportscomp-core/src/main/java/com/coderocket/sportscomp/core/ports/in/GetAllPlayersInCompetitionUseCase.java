package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface GetAllPlayersInCompetitionUseCase {

    List<Player> getAllPlayersInCompetitionByCompetitionId(Integer id);
}
