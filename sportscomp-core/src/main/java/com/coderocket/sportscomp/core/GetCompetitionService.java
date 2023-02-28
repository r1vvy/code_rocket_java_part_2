package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.in.competition.GetCompetitionByIdUseCase;
import com.coderocket.sportscomp.core.ports.out.FindCompetitionByIdPort;
import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GetCompetitionService implements GetCompetitionByIdUseCase {
    private final FindCompetitionByIdPort port;

    @Override
    public Competition getCompetition(Integer id) {

        return port.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No Competition object found with id = " + id));
    }
}
