package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.database.CompetitionRepository;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.exceptions.NoElementFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public void createCompetition(Competition competition) {
        competitionRepository.save(competition);
    }

    public ArrayList<Competition> getAllCompetitionsAsArrayList() {
        return competitionRepository
                .getAllCompetitions()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Competition getCompetitionById(Integer id) {
        return competitionRepository.findCompetitionByCompetitionId(id)
                .orElseThrow(() -> new NoElementFoundException("No Competition object found with supplied id"));
    }
}
