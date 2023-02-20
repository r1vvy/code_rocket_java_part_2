package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.database.PlayerRepository;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.exceptions.NotImplementedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    // TODO
    public List<Player> getAllPlayers() {
        throw new NotImplementedException("Not implemented yet");
    }
}
