package com.coderocket.sportscomp.domain.usecase.player;

import com.coderocket.sportscomp.domain.Player;

import java.util.List;

public interface GetAllPlayersUseCase {

    List<Player> getAllPlayers();
}
