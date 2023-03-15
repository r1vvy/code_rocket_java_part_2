package com.coderocket.sportscomp.core.services;

import com.coderocket.sportscomp.core.ports.in.GetAllPlayersInCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.out.FindAllPlayersInCompetitionByCompetitionIdPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.domain.PlayerInCompetition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllPlayersInCompetitionService implements GetAllPlayersInCompetitionUseCase {

    private FindAllPlayersInCompetitionByCompetitionIdPort findAllPlayersInCompetitionByCompetitionIdPort;

    @Override
    public List<PlayerInCompetition> getAllPlayersInCompetitionByCompetitionId(Integer id) {
        return findAllPlayersInCompetitionByCompetitionIdPort.findAll(id);
    }
}
