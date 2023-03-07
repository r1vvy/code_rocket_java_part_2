package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.request.AddPlayerToCompetitionRequest;
import org.springframework.stereotype.Component;

@Component
public class AddPlayerToCompetitionInRequestToDomainConverter {

    public Player convert(AddPlayerToCompetitionRequest request) {
        return Player.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .rating(request.rating())
                .build();
    }
}
