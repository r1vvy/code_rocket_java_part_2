package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface FindAllPlayersInCompetitionByCompetitionIdPort {

    List<Player> findAll(Integer id);
}
