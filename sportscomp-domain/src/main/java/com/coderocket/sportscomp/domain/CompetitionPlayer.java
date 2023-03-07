package com.coderocket.sportscomp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompetitionPlayer {
    Competition competition;
    Player player;
    Integer ratingChange;
    Integer placement;

}
