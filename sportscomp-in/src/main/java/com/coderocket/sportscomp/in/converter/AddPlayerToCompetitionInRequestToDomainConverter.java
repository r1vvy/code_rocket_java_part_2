package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.competitionPlayer;
import com.coderocket.sportscomp.in.dto.request.AddPlayerToCompetitionRequest;
import org.springframework.stereotype.Component;

@Component
public class AddPlayerToCompetitionInRequestToDomainConverter {

    public competitionPlayer convert(AddPlayerToCompetitionRequest request) {
        return competitionPlayer.builder()
                .playerId(request.playerId())
                .ratingChange(request.ratingChange())
                .build();
    }
}
