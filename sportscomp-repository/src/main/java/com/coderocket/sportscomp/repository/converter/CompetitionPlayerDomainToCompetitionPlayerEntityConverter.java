package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.competitionPlayer;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerKey;
import org.springframework.stereotype.Component;

@Component
public class CompetitionPlayerDomainToCompetitionPlayerEntityConverter {

    public CompetitionPlayerEntity convert(competitionPlayer competitionPlayer, CompetitionEntity competitionEntity) {

        return CompetitionPlayerEntity.builder()
                .id(new CompetitionPlayerKey(competitionPlayer.getPlayerId(), competitionEntity.getId()))
                .placement(competitionPlayer.getPlacement())
                .ratingChange(competitionPlayer.getRatingChange())
                .competitionEntity(competitionEntity)
                .build();
    }
}
