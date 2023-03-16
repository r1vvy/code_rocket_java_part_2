package com.coderocket.sportscomp.in.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AddPlayerToCompetitionRequest(
        @NotNull(message = "id cannot be null")
        Integer playerId,

        @PositiveOrZero(message = "placement in a competition must be a positive or zero value")
        Integer placement,

        Integer ratingChange
) {
}
