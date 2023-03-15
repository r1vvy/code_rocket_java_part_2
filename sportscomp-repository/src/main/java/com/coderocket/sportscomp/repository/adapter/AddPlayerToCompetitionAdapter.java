package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.AddPlayerToCompetitionPort;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.competitionPlayer;
import com.coderocket.sportscomp.repository.converter.CompetitionPlayerDomainToCompetitionPlayerEntityConverter;
import com.coderocket.sportscomp.repository.converter.PlayerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AddPlayerToCompetitionAdapter implements AddPlayerToCompetitionPort {
    private final CompetitionPlayerRepository competitionPlayerRepository;
    private final CompetitionRepository competitionRepository;
    private final PlayerRepository playerRepository;
    private final CompetitionPlayerDomainToCompetitionPlayerEntityConverter domainToCompetitionPlayerEntityConverter;
    private final PlayerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter playerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter;
    @Override
    @Transactional
    public PlayerInCompetition addPlayerToCompetition(competitionPlayer competitionPlayer, Integer competitionId) {

        var competitionEntity = competitionRepository
                .findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with id = " + competitionId));
        var playerEntity = playerRepository
                .findById(competitionPlayer.getPlayerId())
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id = " + competitionPlayer.getPlayerId()));

        var competitionPlayerEntity = domainToCompetitionPlayerEntityConverter.convert(competitionPlayer, competitionEntity);
        competitionPlayerRepository.save(competitionPlayerEntity);

        return playerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter.convert(playerEntity, competitionPlayerEntity);
    }
}
