package com.coderocket.sportscomp.in.dto.request.player;

public record UpdatePlayerInRequest (
    String firstName,
    String lastName,
    Integer rating
) {
}
