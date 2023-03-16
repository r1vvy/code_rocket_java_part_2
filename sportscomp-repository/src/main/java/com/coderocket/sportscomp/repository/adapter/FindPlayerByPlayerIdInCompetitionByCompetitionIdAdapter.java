package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.out.FindPlayerByIdFromCompetitionByIdPort;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.repository.converter.CompetitionPlayerEntityToPlayerInCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerKey;
import com.coderocket.sportscomp.repository.repository.CompetitionPlayerRepository;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindPlayerByPlayerIdInCompetitionByCompetitionIdAdapter implements FindPlayerByIdFromCompetitionByIdPort {
    private final CompetitionPlayerRepository competitionPlayerRepository;
    private final PlayerRepository playerRepository;
    private final CompetitionPlayerEntityToPlayerInCompetitionDomainConverter competitionPlayerEntityToPlayerInCompetitionDomainConverter;

    @Override
    public PlayerInCompetition findByPlayerIdFromCompetitionById(Integer playerId, Integer competitionId) {
        var playerEntity = playerRepository.findById(playerId).orElseThrow(() -> new NoEntityFoundException("No player found with id = " + playerId));
        var competitionPlayerEntity = competitionPlayerRepository.findById(new CompetitionPlayerKey(playerId, competitionId))
                .orElseThrow(() -> new NoEntityFoundException("No competition player found with playerId = " + playerId + " and competitionId = " + competitionId));

        var playerInCompetition = competitionPlayerEntityToPlayerInCompetitionDomainConverter.convert(competitionPlayerEntity, playerEntity);

        return playerInCompetition;
    }
}
