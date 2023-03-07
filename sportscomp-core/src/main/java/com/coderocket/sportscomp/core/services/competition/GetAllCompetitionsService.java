package com.coderocket.sportscomp.core.services.competition;

import com.coderocket.sportscomp.core.ports.out.competition.FindAllCompetitionsPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.core.ports.in.competition.GetAllCompetitionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllCompetitionsService implements GetAllCompetitionsUseCase {

    private final FindAllCompetitionsPort port;

    @Override
    public List<Competition> getAllCompetitions() {
        return port.findAll();
    }
}
