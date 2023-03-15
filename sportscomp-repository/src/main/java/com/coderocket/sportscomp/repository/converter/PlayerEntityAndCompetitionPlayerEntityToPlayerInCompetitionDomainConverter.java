package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter {
    private final PlayerEntityToPlayerDomainConverter entityToPlayerDomainConverter;

    public PlayerInCompetition convert(PlayerEntity playerEntity, CompetitionPlayerEntity competitionPlayerEntity) {
        return new PlayerInCompetition(
                entityToPlayerDomainConverter.convert(playerEntity),
                competitionPlayerEntity.getPlacement(),
                competitionPlayerEntity.getRatingChange()
        );
    }
}
