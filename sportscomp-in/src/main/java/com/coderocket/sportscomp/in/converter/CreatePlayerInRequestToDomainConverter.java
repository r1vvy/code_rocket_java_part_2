package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.CreatePlayerInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerInRequestToDomainConverter {

    public Player convert(CreatePlayerInRequest request) {
        return Player.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .rating(request.getRating())
                .build();
    }
}
