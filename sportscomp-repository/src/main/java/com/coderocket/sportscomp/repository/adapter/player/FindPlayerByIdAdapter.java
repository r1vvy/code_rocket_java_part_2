package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.FindPlayerByIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindPlayerByIdAdapter implements FindPlayerByIdPort {
    private final PlayerRepository playerRepository;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    @Transactional
    public Optional<Player> findById(Integer id) {
        return playerRepository.findById(id)
                .map(playerEntityToPlayerDomainConverter::convert);
    }
}
