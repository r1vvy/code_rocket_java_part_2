package com.coderocket.sportscomp.repository.converter;


import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerDomainToPlayerEntityConverter {

    public PlayerEntity convert(Player player) {
        return PlayerEntity.builder()
                .id((player.getId()))
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .rating(player.getRating())
                .build();
    }
}
