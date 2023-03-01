package com.coderocket.sportscomp.in.dto.request.competition;


import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateCompetitionInRequest {
    String Title;
    Integer capacity;
    LocalDate registrationOpen;
    LocalDate registrationClose;
    LocalDate startDate;
    LocalDate endDate;
}
