package com.coderocket.sportscomp.repository.adapter.competition;

import com.coderocket.sportscomp.core.ports.out.FindCompetitionByIdPort;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.repository.CompetitionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class FindCompetitionByIdAdapter implements FindCompetitionByIdPort {
    private final CompetitionRepository repository;

    @Override
    public Optional<Competition> findById(Integer id) {
        return repository.findById(id);
    }
}
