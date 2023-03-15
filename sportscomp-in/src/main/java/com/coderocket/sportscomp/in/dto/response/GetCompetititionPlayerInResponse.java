package com.coderocket.sportscomp.in.dto.response;

import com.coderocket.sportscomp.domain.Player;

public record GetCompetititionPlayerInResponse(
        Player player,
        Integer placement,
        Integer ratingChange
) {
}
