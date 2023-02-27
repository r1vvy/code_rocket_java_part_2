package com.coderocket.sportscomp.repository.converter;


import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.PlayerEntity;
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
