package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.request.player.CreatePlayerInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerInRequestToDomainConverter {

    public Player convert(CreatePlayerInRequest request) {
        return Player.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .rating(request.rating())
                .build();
    }
}
