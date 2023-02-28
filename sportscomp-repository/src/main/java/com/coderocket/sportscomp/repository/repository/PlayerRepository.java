package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    void save(Player player);

    Optional<Player> findPlayerById(Integer id);
    List<Player> findAllPlayers();
}
