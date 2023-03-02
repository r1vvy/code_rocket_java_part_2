package com.coderocket.sportscomp.domain;

import lombok.Builder;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@Builder
public class Competition {
    Integer id;
    String title;
    Integer capacity;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate registrationOpen;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate registrationClose;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate startDate;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate endDate;



}
