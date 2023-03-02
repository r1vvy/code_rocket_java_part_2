package com.coderocket.sportscomp.in.dto.response.competition;

public record GetCompetitionInResponse(
        Integer id,
        String title,
        Integer capacity,
        String registrationOpen,
        String registrationClose,
        String startDate,
        String endDate
) {
}
