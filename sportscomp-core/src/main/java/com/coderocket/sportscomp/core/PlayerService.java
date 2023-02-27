package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAllPlayers();
    }
}
