package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.UpdatePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePlayerAdapter implements UpdatePlayerPort {
    private final PlayerRepository playerRepository;
    private final PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    @Transactional
    public Player updatePlayer(Player updatedPlayer, Integer id) {
        var entity = playerDomainToPlayerEntityConverter.convert(updatedPlayer);
        entity.setId(id);
        var savedEntity = playerRepository.save(entity);

        return playerEntityToPlayerDomainConverter.convert(savedEntity);
    }
}
