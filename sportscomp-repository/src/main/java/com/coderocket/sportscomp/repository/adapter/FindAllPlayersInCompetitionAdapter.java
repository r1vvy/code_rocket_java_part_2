package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.FindAllPlayersInCompetitionByCompetitionIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.entity.PlayerInCompetition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllPlayersInCompetitionAdapter implements FindAllPlayersInCompetitionByCompetitionIdPort {
    private CompetitionRepository competitionRepository;
    private PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    public List<Player> findAll(Integer id) {
        var competition = competitionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return competition.getPlayers()
                .stream()
                .map(PlayerInCompetition::getPlayerEntity)
                .map(playerEntityToPlayerDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
