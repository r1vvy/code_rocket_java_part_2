package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.player.DeletePlayerUseCase;
import com.coderocket.sportscomp.core.ports.out.DeletePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePlayerService implements DeletePlayerUseCase {
    private DeletePlayerPort port;

    @Override
    public void deletePlayer(Player player) {
        port.delete(player);
    }
}
