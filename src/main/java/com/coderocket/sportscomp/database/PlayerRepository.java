package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.domain.Player;

import java.util.stream.Stream;

public interface PlayerRepository {

    void save(Player player);

    Stream<Player> getAllPlayers();
}
