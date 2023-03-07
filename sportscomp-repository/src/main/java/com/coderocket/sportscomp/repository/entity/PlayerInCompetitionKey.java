package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInCompetitionKey implements Serializable {
    @Column(name = "player_id")
    Integer playerId;

    @Column(name = "competition_id")
    Integer competitionId;
}
