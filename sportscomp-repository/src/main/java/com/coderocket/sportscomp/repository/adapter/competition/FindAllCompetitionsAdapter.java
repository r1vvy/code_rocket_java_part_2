package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.FindAllCompetitionsPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class FindAllCompetitionsAdapter implements FindAllCompetitionsPort {

    private final CompetitionRepository repository;

    @Override
    public List<Competition> findAll() {
        return repository.findAllCompetitions();
    }
}
