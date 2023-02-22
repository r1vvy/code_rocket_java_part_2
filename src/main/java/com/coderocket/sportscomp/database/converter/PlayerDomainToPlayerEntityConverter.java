package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.PlayerEntity;
import com.coderocket.sportscomp.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDomainToPlayerEntityConverter {

    public PlayerEntity convert(Player player) {
        return PlayerEntity.builder()
                .name(player.getName())
                .surname(player.getSurname())
                .rating(player.getRating())
                .build();
    }
}
