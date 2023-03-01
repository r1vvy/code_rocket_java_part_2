package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.DeletePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeletePlayerAdapter implements DeletePlayerPort {
    private final PlayerRepository playerRepository;

    @Override
    public void delete(Player player) {
        playerRepository.delete(player);
    }
}
