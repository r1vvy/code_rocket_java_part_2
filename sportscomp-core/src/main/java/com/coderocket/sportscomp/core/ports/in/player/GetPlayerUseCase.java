package com.coderocket.sportscomp.core.ports.in.player;

import com.coderocket.sportscomp.domain.Player;

public interface GetPlayerUseCase {

    Player getPlayer(Integer id);
}
