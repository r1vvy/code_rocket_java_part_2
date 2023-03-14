package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "competitions_players")
@Getter
@Setter
@RequiredArgsConstructor
public class CompetitionPlayerEntity {
    @EmbeddedId
    CompetitionPlayerKey id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("competitionEntityId")
    @JoinColumn(name = "competition_id")
    CompetitionEntity competitionEntity;

    @Column(name = "rating_change")
    Integer ratingChange;

    @Column(name = "placement")
    Integer placement;

    public CompetitionPlayerEntity(CompetitionPlayerKey id, Integer ratingChange, Integer placement) {
        this.id = id;
        this.ratingChange = ratingChange;
        this.placement = placement;
    }
}
