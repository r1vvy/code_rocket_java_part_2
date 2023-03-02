package com.coderocket.sportscomp.in.dto.response.player;

public record GetPlayerInResponse(
        Integer id,
        String firstName,
        String lastName,
        Integer rating
) {
}
