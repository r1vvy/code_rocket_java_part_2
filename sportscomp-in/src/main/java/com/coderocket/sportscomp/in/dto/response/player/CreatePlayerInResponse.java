package com.coderocket.sportscomp.in.dto.response.player;

public record CreatePlayerInResponse (
        Integer id,
        String firstName,
        String lastName,
        Integer rating
) { }
