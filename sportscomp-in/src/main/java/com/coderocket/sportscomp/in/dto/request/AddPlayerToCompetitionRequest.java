package com.coderocket.sportscomp.in.dto.request;

public record AddPlayerToCompetitionRequest(
        Integer id,
        String firstName,
        String lastName,
        Integer rating
) {
}
