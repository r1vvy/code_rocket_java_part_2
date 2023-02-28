package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

public interface SavePlayerPort {

    void save(Player player);
}
