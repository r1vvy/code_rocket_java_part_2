package com.coderocket.sportscomp.in.dto.request.competition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateCompetitionInRequest(
        @NotBlank(message = "title must not be blank")
        String title,
        @NotNull(message = "capacity must not be null")
        Integer capacity,
        LocalDate registrationOpen,
        LocalDate registrationClose,
        LocalDate startDate,
        LocalDate endDate
) {
}
