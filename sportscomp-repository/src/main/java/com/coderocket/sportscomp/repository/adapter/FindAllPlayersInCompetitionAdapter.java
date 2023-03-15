package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.FindAllPlayersInCompetitionByCompetitionIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.repository.converter.PlayerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllPlayersInCompetitionAdapter implements FindAllPlayersInCompetitionByCompetitionIdPort {
    private final CompetitionRepository competitionRepository;
    private final CompetitionPlayerRepository competitionPlayerRepository;
    private final PlayerRepository playerRepository;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;
    private final PlayerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter playerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter;


    @Override
    @Transactional
    public List<PlayerInCompetition> findAll(Integer id) {

        List<CompetitionPlayerEntity> competitionPlayerEntities = competitionPlayerRepository
                .findAllByIdCompetitionEntityId(id);

        return competitionPlayerEntities.stream()
                .map(competitionPlayerEntity -> {
                    var playerEntity = playerRepository.findById(competitionPlayerEntity.getId().getPlayerEntityId())
                            .orElseThrow(() -> new RuntimeException("Player not found for id " + competitionPlayerEntity.getId().getPlayerEntityId()));
                    return playerEntityAndCompetitionPlayerEntityToPlayerInCompetitionDomainConverter.convert(playerEntity, competitionPlayerEntity);
                })
                .collect(Collectors.toList());
    }
}
