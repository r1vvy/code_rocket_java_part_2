package com.coderocket.sportscomp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class competitionPlayer {
    Integer playerId;
    Integer ratingChange;
    Integer placement;
}
