package com.coderocket.sportscomp.domain.holder;

import com.coderocket.sportscomp.domain.Competition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChosenCompetitionHolder {
    // TODO: should research this more
    private static final ThreadLocal<Competition> chosenCompetition = new ThreadLocal<>();

    public static Competition getChosenCompetition() {
        return chosenCompetition.get();
    }

    public static void setChosenCompetition(Competition competition) {
        chosenCompetition.set(competition);
    }

    public static void clearChosenCompetition() {
        chosenCompetition.remove();
    }
}
