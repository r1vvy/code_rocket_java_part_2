package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

public interface SavePlayerPort {

    Player save(Player player);
}
