package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.request.player.UpdatePlayerInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdatePlayerInRequestToDomainConverter {

    public Player convert(UpdatePlayerInRequest request) {
        return Player.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .rating(request.rating())
                .build();
    }
}
