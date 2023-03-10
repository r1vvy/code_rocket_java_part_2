package com.coderocket.sportscomp.in.dto.request.competition;

public record CreateCompetitionInRequest(
        String title,
        Integer capacity,
        String registrationOpen,
        String registrationClose,
        String startDate,
        String endDate
) { }
