package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.PlayerInCompetition;

import java.util.List;

public interface FindAllPlayersInCompetitionByCompetitionIdPort {

    List<PlayerInCompetition> findAll(Integer id);
}
