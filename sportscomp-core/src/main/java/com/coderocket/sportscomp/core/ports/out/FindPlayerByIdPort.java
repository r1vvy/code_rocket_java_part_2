package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Player;

import java.util.Optional;

public interface FindPlayerByIdPort {

    Optional<Player> findById(Integer id);
}
