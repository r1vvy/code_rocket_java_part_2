package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.CompetitionPlayer;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class CompetitionPlayerEntityToDomainConverter {

    public CompetitionPlayer convert(CompetitionPlayerEntity competitionPlayerEntity) {
        return CompetitionPlayer.builder()
                .playerId(competitionPlayerEntity.getId().getPlayerEntityId())
                .placement(competitionPlayerEntity.getPlacement())
                .ratingChange(competitionPlayerEntity.getRatingChange())
                .build();
    }
}
