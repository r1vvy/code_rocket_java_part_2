package com.coderocket.sportscomp.in.dto.response.player;

public record DeletePlayerInResponse (
    Integer id,
    String firstName,
    String lastName,
    Integer rating
) {
}
