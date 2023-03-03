package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.player.UpdatePlayerUseCase;
import com.coderocket.sportscomp.core.ports.out.player.UpdatePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePlayerService implements UpdatePlayerUseCase {

    private final UpdatePlayerPort updatePlayerPort;

    @Override
    public Player updatePlayer(Player updatedPlayer, Integer id) {
        return updatePlayerPort.updatePlayer(updatedPlayer, id);
    }
}
