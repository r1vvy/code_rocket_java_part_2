package com.coderocket.sportscomp.core.ports.in.player;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface GetAllPlayersUseCase {

    List<Player> getAllPlayers();
}
