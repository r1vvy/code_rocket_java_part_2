package com.coderocket.sportscomp.in.dto;


import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateCompetitionInRequest implements Request {
    String Title;
    Integer capacity;
    LocalDate registrationOpen;
    LocalDate registrationClose;
    LocalDate startDate;
    LocalDate endDate;
}
