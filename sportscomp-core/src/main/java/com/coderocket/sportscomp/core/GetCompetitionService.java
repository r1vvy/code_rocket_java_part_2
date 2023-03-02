package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.core.ports.out.competition.FindCompetitionByIdPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.core.ports.in.competition.GetCompetitionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GetCompetitionService implements GetCompetitionUseCase {
    private final FindCompetitionByIdPort port;

    @Override
    public Competition getCompetitionById(Integer id) {

        return port.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No Competition object found with id = " + id));
    }
}
