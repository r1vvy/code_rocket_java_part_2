package com.coderocket.sportscomp.core.ports.out.player;

import com.coderocket.sportscomp.domain.Player;

public interface UpdatePlayerPort {

    public Player updatePlayer(Player updatedPlayer, Integer id);
}
