package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.CompetitionPlayer;
import com.coderocket.sportscomp.in.dto.request.AddPlayerToCompetitionRequest;
import org.springframework.stereotype.Component;

@Component
public class AddPlayerToCompetitionInRequestToDomainConverter {

    public CompetitionPlayer convert(AddPlayerToCompetitionRequest request) {
        return CompetitionPlayer.builder()
                .playerId(request.playerId())
                .ratingChange(request.ratingChange())
                .placement(request.placement())
                .build();
    }
}
