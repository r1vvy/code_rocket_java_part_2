package com.coderocket.sportscomp.in.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddPlayerToCompetitionRequest(
        @NotNull
        Integer playerId,

        @NotBlank
        Integer placement,

        @NotBlank
        Integer ratingChange
) {
}
