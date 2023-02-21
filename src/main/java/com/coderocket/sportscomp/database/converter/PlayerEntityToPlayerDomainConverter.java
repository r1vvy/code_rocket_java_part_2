package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.PlayerEntity;
import com.coderocket.sportscomp.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerEntityToPlayerDomainConverter {

    public Player convert(PlayerEntity entity) {
        return Player.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .rating(entity.getRating())
                .build();
    }
}
