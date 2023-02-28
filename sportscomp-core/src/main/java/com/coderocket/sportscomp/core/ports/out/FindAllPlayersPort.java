package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface FindAllPlayersPort {

    List<Player> findAll();
}
