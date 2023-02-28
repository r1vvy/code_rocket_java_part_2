package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.FindAllPlayersPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class FindAllPlayersAdapter implements FindAllPlayersPort {
    private final PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAllPlayers();
    }
}
