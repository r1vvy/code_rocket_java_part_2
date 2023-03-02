package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.competition.SaveCompetitionPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveCompetitionAdapter implements SaveCompetitionPort {

    private final CompetitionRepository repository;

    @Override
    public Competition save(Competition competition) {
        return repository.save(competition);
    }
}
