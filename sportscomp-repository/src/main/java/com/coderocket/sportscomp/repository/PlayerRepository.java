package com.coderocket.sportscomp.repository;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface PlayerRepository {

    void save(Player player);

    List<Player> findAllPlayers();
}
