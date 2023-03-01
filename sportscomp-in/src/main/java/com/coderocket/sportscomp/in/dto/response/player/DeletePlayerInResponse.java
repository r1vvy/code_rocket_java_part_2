package com.coderocket.sportscomp.in.dto.response.player;

public record DeletePlayerInResponse (
    Integer id,
    String name,
    String surname,
    Integer rating
) {
}
