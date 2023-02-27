package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Competition;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapContextHolder implements CompetitionContextHolder {

    private final ConcurrentHashMap<Thread, Competition> competitionMap = new ConcurrentHashMap<>();

    @Override
    public Competition getChosenCompetition() {
        Competition competition = competitionMap.get(Thread.currentThread());
        if (competition == null) {
            throw new IllegalStateException("No competition has been set for this thread");
        }
        return competition;
    }

    @Override
    public void setChosenCompetition(Competition competition) {
        competitionMap.put(Thread.currentThread(), competition);
    }

    @Override
    public void clearChosenCompetition() {
        competitionMap.remove(Thread.currentThread());
    }
}
