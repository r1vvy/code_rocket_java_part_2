package com.coderocket.sportscomp.repository.converter;


import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerEntityToPlayerDomainConverter {

    public Player convert(PlayerEntity entity) {
        return Player.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .rating(entity.getRating())
                .id(entity.getId())
                .build();
    }
}
