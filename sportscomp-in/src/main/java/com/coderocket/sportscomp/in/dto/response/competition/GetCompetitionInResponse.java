package com.coderocket.sportscomp.in.dto.response.competition;

import java.time.LocalDate;

public record GetCompetitionInResponse(
        Integer id,
        String title,
        Integer capacity,
        LocalDate registrationOpen,
        LocalDate registrationClose,
        LocalDate startDate,
        LocalDate endDate
) {
}
