package com.coderocket.sportscomp.in.dto.response;

public record GetCompetitionPlayerInResponse(
        String playerEndpoint,
        Integer placement,
        Integer ratingChange
) {
}
