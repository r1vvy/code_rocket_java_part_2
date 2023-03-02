package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.out.player.FindPlayerByIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.core.ports.in.player.GetPlayerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPlayerService implements GetPlayerUseCase {
    private final FindPlayerByIdPort port;

    @Override
    public Player getPlayer(Integer id) {
        return port.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No Player object found with id = " + id));
    }
}
