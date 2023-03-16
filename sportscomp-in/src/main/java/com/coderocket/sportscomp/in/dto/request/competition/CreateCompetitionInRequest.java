package com.coderocket.sportscomp.in.dto.request.competition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateCompetitionInRequest(

        @NotBlank(message = "title must not be blank")
        String title,
        @NotNull(message = "capacity must not be null")
        Integer capacity,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date should be YYYY-MM-DD pattern")
        String registrationOpen,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date should be YYYY-MM-DD pattern")
        String registrationClose,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date should be YYYY-MM-DD pattern")
        String startDate,
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date should be YYYY-MM-DD pattern")
        String endDate
) { }
