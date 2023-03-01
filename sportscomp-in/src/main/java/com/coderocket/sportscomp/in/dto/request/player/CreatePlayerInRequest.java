package com.coderocket.sportscomp.in.dto.request.player;

public record CreatePlayerInRequest (
        String name,
        String surname,
        Integer rating
)
{

}
