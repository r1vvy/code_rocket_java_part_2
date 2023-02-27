package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Competition;

public interface CompetitionContextHolder {
    Competition getChosenCompetition();
    void setChosenCompetition(Competition competition);
    void clearChosenCompetition();
}
