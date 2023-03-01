package com.coderocket.sportscomp.domain.usecase.player;

import com.coderocket.sportscomp.domain.Player;

public interface GetPlayerUseCase {

    Player getPlayer(Integer id);
}
