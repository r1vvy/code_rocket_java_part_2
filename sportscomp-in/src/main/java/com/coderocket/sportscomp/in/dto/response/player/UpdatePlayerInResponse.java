package com.coderocket.sportscomp.in.dto.response.player;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;

public record UpdatePlayerInResponse (
        Integer id,
        String firstName,
        String lastName,
        Integer rating,
        ChuckNorrisJoke chuckNorrisJoke
) {
}
