package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.UpdatePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Transactional
public class UpdatePlayerAdapter implements UpdatePlayerPort {
    private final PlayerRepository playerRepository;

    @Override
    public Player updatePlayer(Player updatedPlayer, Integer id) {
        return playerRepository.update(updatedPlayer, id);
    }
}
