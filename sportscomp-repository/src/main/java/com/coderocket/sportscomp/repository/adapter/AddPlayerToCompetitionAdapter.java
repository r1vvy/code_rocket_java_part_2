package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.AddPlayerToCompetitionPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerKey;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AddPlayerToCompetitionAdapter implements AddPlayerToCompetitionPort {
    CompetitionPlayerRepository competitionPlayerRepository;
    CompetitionRepository competitionRepository;
    PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;

    @Override
    @Transactional
    public void addPlayerToCompetition(Player player, Integer competitionId) {
        // Find the competition entity by its ID
        CompetitionEntity competitionEntity = competitionRepository
                .findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid competition ID"));

        var playerEntity = playerDomainToPlayerEntityConverter.convert(player);

        CompetitionPlayerKey competitionPlayerKey = new CompetitionPlayerKey();
        competitionPlayerKey.setCompetitionEntityId(competitionId);
        competitionPlayerKey.setPlayerEntityId(playerEntity.getId());

        CompetitionPlayerEntity competitionPlayerEntity = new CompetitionPlayerEntity(competitionPlayerKey, 0, 0);
        competitionPlayerEntity.setCompetitionEntity(competitionEntity);
        competitionPlayerEntity.setPlayerEntity(playerEntity);

        competitionPlayerRepository.save(competitionPlayerEntity);
    }
}
