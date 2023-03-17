package com.coderocket.sportscomp.core.services;

import com.coderocket.sportscomp.core.ports.in.AddPlayerToCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.AddPlayerToCompetitionPort;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import com.coderocket.sportscomp.domain.CompetitionPlayer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddPlayerToCompetitionService implements AddPlayerToCompetitionUseCase {
    private final AddPlayerToCompetitionPort addPlayerToCompetitionPort;
    @Override
    public PlayerInCompetition addPlayerToCompetitionByCompetitionId(CompetitionPlayer competitionPlayer, Integer competitionId) {
        return addPlayerToCompetitionPort.addPlayerToCompetition(competitionPlayer, competitionId);
    }
}
