package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Competition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component("competitionContextHolder")
@AllArgsConstructor
public class ThreadLocalCompetitionContextHolder implements CompetitionContextHolder {
    private final ThreadLocal<Competition> chosenCompetition = new ThreadLocal<>();

    @Override
    public Competition getChosenCompetition() {
        Competition competition = chosenCompetition.get();
        if (competition == null) {
            throw new IllegalStateException("No competition has been set for this thread");
        }
        return competition;
    }

    @Override
    public void setChosenCompetition(Competition competition) {
        chosenCompetition.set(competition);
    }

    @Override
    public void clearChosenCompetition() {
        chosenCompetition.remove();
    }
}
