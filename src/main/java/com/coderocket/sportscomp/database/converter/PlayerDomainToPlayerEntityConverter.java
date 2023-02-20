package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.PlayerEntity;
import com.coderocket.sportscomp.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDomainToPlayerEntityConverter {

    public PlayerEntity convert(Player player, Integer id) {
        return new PlayerEntity(id, player.getName(), player.getSurname(), player.getRating());
    }
}
