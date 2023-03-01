package com.coderocket.sportscomp.in.dto.response.player;

public record CreatePlayerInResponse (
        Integer id,
        String name,
        String surname,
        Integer rating
) { }
