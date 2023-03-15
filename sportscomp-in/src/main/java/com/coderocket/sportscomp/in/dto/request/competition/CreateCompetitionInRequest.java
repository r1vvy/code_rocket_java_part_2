package com.coderocket.sportscomp.in.dto.request.competition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateCompetitionInRequest(

        @NotBlank
        String title,
        @NotNull
        Integer capacity,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
        String registrationOpen,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
        String registrationClose,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
        String startDate,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
        String endDate
) { }
