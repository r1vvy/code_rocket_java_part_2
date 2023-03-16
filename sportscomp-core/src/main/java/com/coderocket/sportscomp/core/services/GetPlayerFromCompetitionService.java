package com.coderocket.sportscomp.core.services;

import com.coderocket.sportscomp.core.ports.in.GetPlayerFromCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.FindPlayerByIdFromCompetitionByIdPort;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetPlayerFromCompetitionService implements GetPlayerFromCompetitionUseCase {
    private final FindPlayerByIdFromCompetitionByIdPort findPlayerByIdFromCompetitionByIdPort;

    @Override
    public PlayerInCompetition getPlayerByIdFromCompetitionById(Integer playerId, Integer competitionId) {
        return findPlayerByIdFromCompetitionByIdPort.findByPlayerIdFromCompetitionById(playerId, competitionId);
    }
}
