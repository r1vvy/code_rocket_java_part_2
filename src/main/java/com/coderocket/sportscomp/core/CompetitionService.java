package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.database.CompetitionRepository;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.exceptions.NoElementFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public void createCompetition(Competition competition) {
        competitionRepository.save(competition);
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAllCompetitions();
    }

    public Competition getCompetitionById(Integer id) {
        return competitionRepository.findCompetitionByCompetitionId(id)
                .orElseThrow(() -> new NoElementFoundException("No Competition object found with id=" + id));
    }
}
