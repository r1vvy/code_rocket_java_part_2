package com.coderocket.sportscomp.domain;

public record PlayerInCompetition(
        Player player,
        Integer placement,
        Integer ratingChange
) {
}
