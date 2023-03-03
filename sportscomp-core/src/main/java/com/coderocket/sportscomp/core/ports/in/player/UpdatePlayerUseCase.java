package com.coderocket.sportscomp.core.ports.in.player;

import com.coderocket.sportscomp.domain.Player;

public interface UpdatePlayerUseCase {
    Player updatePlayer(Player updatedPlayer, Integer id);
}
