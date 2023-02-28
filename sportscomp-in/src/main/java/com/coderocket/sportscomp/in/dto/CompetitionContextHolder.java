package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Competition;

public interface CompetitionContextHolder extends ContextHolder {
    Competition getChosenCompetition();
    void setChosenCompetition(Competition competition);
}
