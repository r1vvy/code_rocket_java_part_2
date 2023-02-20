package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.domain.Player;

public interface PlayerRepository {

    void save(Player player);
}
