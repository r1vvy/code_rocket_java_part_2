package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.ports.in.player.SavePlayerUseCase;
import com.coderocket.sportscomp.core.ports.out.SavePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SavePlayerService implements SavePlayerUseCase {
    private final SavePlayerPort port;

    @Override
    public Player savePlayer(Player player) {
        return port.save(player);
    }
}
