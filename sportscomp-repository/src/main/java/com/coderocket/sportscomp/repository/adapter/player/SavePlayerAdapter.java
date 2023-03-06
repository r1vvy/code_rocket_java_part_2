package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.SavePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SavePlayerAdapter implements SavePlayerPort {
    private final PlayerRepository repository;
    private final PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    public Player save(Player player) {
        var entity = playerDomainToPlayerEntityConverter.convert(player);
        var savedPlayer = repository.save(entity);

        return playerEntityToPlayerDomainConverter.convert(savedPlayer);
    }
}
