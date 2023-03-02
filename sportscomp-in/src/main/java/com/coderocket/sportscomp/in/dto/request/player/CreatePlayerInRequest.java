package com.coderocket.sportscomp.in.dto.request.player;

public record CreatePlayerInRequest (
        String firstName,
        String lastName,
        Integer rating
)
{

}
