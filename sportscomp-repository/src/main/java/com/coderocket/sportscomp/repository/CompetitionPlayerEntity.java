package com.coderocket.sportscomp.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "competition_players")
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionPlayerEntity {


    @EmbeddedId
    CompetitionPlayerKey id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    PlayerEntity playerEntity;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    CompetitionEntity competitionEntity;

    Integer ratingChange;

    Integer placement;
}
