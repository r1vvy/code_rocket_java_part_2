package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.FindAllPlayersInCompetitionByCompetitionIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class FindAllPlayersInCompetitionAdapter implements FindAllPlayersInCompetitionByCompetitionIdPort {
    private final CompetitionRepository competitionRepository;
    private final CompetitionPlayerRepository competitionPlayerRepository;
    private final PlayerRepository playerRepository;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    @Transactional
    public List<Player> findAll(Integer id) {

        List<Integer> playerIds = competitionPlayerRepository
                .findAllByIdCompetitionEntityId(id)
                .stream()
                .map(competitionPlayerEntity -> competitionPlayerEntity.getId().getPlayerEntityId())
                .collect(Collectors.toList());

        return StreamSupport.stream(playerRepository.findAllById(playerIds).spliterator(), false)
                .map(playerEntityToPlayerDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
