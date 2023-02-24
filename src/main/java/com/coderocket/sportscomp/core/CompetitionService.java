package com.coderocket.sportscomp.core;

import com.coderocket.sportscomp.core.exceptions.NoEntityFoundException;
import com.coderocket.sportscomp.database.CompetitionRepository;
import com.coderocket.sportscomp.domain.Competition;
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
        if(competitionRepository.findAllCompetitions().isEmpty())
            throw new NoEntityFoundException("No competition added yet");
        else {
            return competitionRepository.findAllCompetitions();
        }
    }

    public void deleteCompetition(Competition competition) {
        competitionRepository.delete(competition);
    }

    public Competition getCompetitionById(Integer id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("No Competition object found with id = " + id));

        return competition;
    }


}
