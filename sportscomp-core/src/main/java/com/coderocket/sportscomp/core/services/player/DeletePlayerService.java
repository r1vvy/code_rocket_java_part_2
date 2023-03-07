package com.coderocket.sportscomp.core.services.player;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.out.player.DeletePlayerPort;
import com.coderocket.sportscomp.core.ports.out.player.FindPlayerByIdPort;
import com.coderocket.sportscomp.core.ports.in.player.DeletePlayerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePlayerService implements DeletePlayerUseCase {
    private DeletePlayerPort deletePlayerPort;
    private FindPlayerByIdPort findPlayerByIdPort;

    @Override
    public void deletePlayerById(Integer id) {
        var player = findPlayerByIdPort.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No player found with id = " + id));

        deletePlayerPort.delete(player);
    }
}
