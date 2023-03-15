package com.coderocket.sportscomp.core.ports.in;

import com.coderocket.sportscomp.domain.PlayerInCompetition;

import java.util.List;

public interface GetAllPlayersInCompetitionUseCase {

    List<PlayerInCompetition> getAllPlayersInCompetitionByCompetitionId(Integer id);
}
