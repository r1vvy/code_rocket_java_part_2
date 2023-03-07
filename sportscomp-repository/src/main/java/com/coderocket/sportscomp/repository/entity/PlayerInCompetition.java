package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInCompetition {
    @EmbeddedId
    PlayerInCompetitionKey id;


    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    PlayerEntity playerEntity;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    CompetitionEntity competitionEntity;

    int ratingChange;
    int placement;
}
