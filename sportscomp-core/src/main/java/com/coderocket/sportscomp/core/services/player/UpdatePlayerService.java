package com.coderocket.sportscomp.core.services.player;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.in.player.UpdatePlayerUseCase;
import com.coderocket.sportscomp.core.ports.out.player.FindPlayerByIdPort;
import com.coderocket.sportscomp.core.ports.out.player.UpdatePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePlayerService implements UpdatePlayerUseCase {

    private final UpdatePlayerPort updatePlayerPort;
    private final FindPlayerByIdPort findPlayerByIdPort;

    @Override
    public Player updatePlayer(Player updatedPlayer, Integer id) {
        findPlayerByIdPort.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No player found with id = " + id));

        return updatePlayerPort.updatePlayer(updatedPlayer, id);
    }
}
