package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class CompetitionPlayerKey implements Serializable {
    @Column(name = "competition_id")
    Integer competitionId;
    @Column(name = "player_id")
    Integer playerId;

}
