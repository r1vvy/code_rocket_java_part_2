package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.DeletePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePlayerAdapter implements DeletePlayerPort {
    private final PlayerRepository playerRepository;
    private final PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;

    @Override
    public void delete(Player player) {
        var entity = playerDomainToPlayerEntityConverter.convert(player);

        playerRepository.delete(entity);
    }
}
