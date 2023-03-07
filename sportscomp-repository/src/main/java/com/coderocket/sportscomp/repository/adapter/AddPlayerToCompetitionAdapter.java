package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.AddPlayerToCompetitionPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.entity.PlayerInCompetition;
import com.coderocket.sportscomp.repository.entity.PlayerInCompetitionKey;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AddPlayerToCompetitionAdapter implements AddPlayerToCompetitionPort {
    CompetitionPlayerRepository competitionPlayerRepository;
    CompetitionRepository competitionRepository;
    PlayerRepository playerRepository;

    PlayerDomainToPlayerEntityConverter playerDomainToPlayerEntityConverter;

    @Override
    @Transactional
    public void addPlayerToCompetition(Player player, Integer competitionId) {
        // Find the competition entity by its ID
        CompetitionEntity competitionEntity = competitionRepository
                .findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid competition ID"));

        var playerEntity = playerDomainToPlayerEntityConverter.convert(player);

        // Create a new PlayerInCompetition instance
        PlayerInCompetition playerInCompetition = new PlayerInCompetition();
        playerInCompetition.setId(
                new PlayerInCompetitionKey(competitionId, playerEntity.getId())
        );
        playerInCompetition.setPlayerEntity(playerEntity);
        playerInCompetition.setCompetitionEntity(competitionEntity);

        // TODO : update also player and competition entities

        competitionRepository.save(competitionEntity);
        playerRepository.save(playerEntity);

        // Save the changes to the database
        competitionPlayerRepository.save(playerInCompetition);
        System.out.println(playerInCompetition);
    }

}
