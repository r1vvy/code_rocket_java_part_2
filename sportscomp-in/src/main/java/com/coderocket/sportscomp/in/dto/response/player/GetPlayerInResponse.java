package com.coderocket.sportscomp.in.dto.response.player;

public record GetPlayerInResponse(
        Integer id,
        String name,
        String surname,
        Integer rating
) {
}
