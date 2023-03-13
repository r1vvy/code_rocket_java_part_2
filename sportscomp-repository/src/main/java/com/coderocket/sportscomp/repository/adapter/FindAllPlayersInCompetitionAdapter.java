package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.FindAllPlayersInCompetitionByCompetitionIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllPlayersInCompetitionAdapter implements FindAllPlayersInCompetitionByCompetitionIdPort {
    private CompetitionRepository competitionRepository;
    private CompetitionPlayerRepository competitionPlayerRepository;
    private PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    @Transactional
    public List<Player> findAll(Integer id) {

        return competitionPlayerRepository.findAllByCompetitionEntityId(id)
                .stream()
                .map(CompetitionPlayerEntity::getPlayerEntity)
                .map(playerEntityToPlayerDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
