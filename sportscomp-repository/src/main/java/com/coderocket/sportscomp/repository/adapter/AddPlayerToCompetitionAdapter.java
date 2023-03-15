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
    private final CompetitionPlayerRepository competitionPlayerRepository;
    private final CompetitionRepository competitionRepository;
    PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;

    @Override
    @Transactional
    public void addPlayerToCompetition(Player player, Integer competitionId) {
        CompetitionEntity competitionEntity = competitionRepository
                .findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid competition ID"));

        CompetitionPlayerKey competitionPlayerKey = new CompetitionPlayerKey(player.getId(), competitionId);

        var competitionPlayerEntity = CompetitionPlayerEntity.builder()
                .id(competitionPlayerKey)
                .placement(0)
                .ratingChange(0)
                .competitionEntity(competitionEntity)
                .build();

        competitionPlayerRepository.save(competitionPlayerEntity);
    }
}
