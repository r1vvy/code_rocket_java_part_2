package com.coderocket.sportscomp.in.dto.request.competition;

import java.time.LocalDate;

public record UpdateCompetitionInRequest(
        String title,
        Integer capacity,
        LocalDate registrationOpen,
        LocalDate registrationClose,
        LocalDate startDate,
        LocalDate endDate
) {
}
