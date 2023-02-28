package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.player.GetAllPlayersUseCase;
import com.coderocket.sportscomp.core.ports.out.FindAllPlayersPort;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllPlayersService implements GetAllPlayersUseCase {
    private final FindAllPlayersPort port;

    @Override
    public List<Player> getAllPlayers() {
        return port.findAll();
    }
}