package com.coderocket.sportscomp.in.dto.response.player;

public record UpdatePlayerInResponse (
        Integer id,
        String firstName,
        String lastName,
        Integer rating
) {
}
