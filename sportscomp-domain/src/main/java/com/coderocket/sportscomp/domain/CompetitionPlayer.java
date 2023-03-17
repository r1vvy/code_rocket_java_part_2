package com.coderocket.sportscomp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompetitionPlayer {
    Integer playerId;
    Integer ratingChange;
    Integer placement;
}
