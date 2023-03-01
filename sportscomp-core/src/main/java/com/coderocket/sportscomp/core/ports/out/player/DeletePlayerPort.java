package com.coderocket.sportscomp.core.ports.out.player;

import com.coderocket.sportscomp.domain.Player;

public interface DeletePlayerPort {
    void delete(Player player);
}
