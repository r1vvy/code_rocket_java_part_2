package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.competitionPlayer;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class CompetitionPlayerEntityToDomainConverter {

    public competitionPlayer convert(CompetitionPlayerEntity competitionPlayerEntity) {
        return competitionPlayer.builder()
                .playerId(competitionPlayerEntity.getId().getPlayerEntityId())
                .placement(competitionPlayerEntity.getPlacement())
                .ratingChange(competitionPlayerEntity.getRatingChange())
                .build();
    }
}
