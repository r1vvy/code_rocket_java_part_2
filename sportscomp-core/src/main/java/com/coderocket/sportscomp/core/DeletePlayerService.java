package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.out.player.DeletePlayerPort;
import com.coderocket.sportscomp.core.ports.out.player.FindPlayerByIdPort;
import com.coderocket.sportscomp.domain.usecase.player.DeletePlayerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePlayerService implements DeletePlayerUseCase {
    private DeletePlayerPort deletePlayerPort;
    private FindPlayerByIdPort findPlayerByIdPort;

    @Override
    public void deletePlayerById(Integer id) {
        var player = findPlayerByIdPort.findById(id);

        deletePlayerPort.delete(player.get());
    }
}
