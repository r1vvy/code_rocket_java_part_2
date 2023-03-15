package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "competitions_players")
@AllArgsConstructor
@NoArgsConstructor
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
}
