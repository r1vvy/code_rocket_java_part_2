package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompetitionPlayerEntityToPlayerInCompetitionDomainConverter {
    PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;
    public PlayerInCompetition convert(CompetitionPlayerEntity competitionPlayerEntity, PlayerEntity playerEntity) {
        return new PlayerInCompetition(
                playerEntityToPlayerDomainConverter.convert(playerEntity),
                competitionPlayerEntity.getPlacement(),
                competitionPlayerEntity.getRatingChange()
                );
    }
}
