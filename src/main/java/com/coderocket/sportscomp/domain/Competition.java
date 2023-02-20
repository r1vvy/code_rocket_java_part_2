package com.coderocket.sportscomp.domain;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
@ToString(doNotUseGetters = true)
public class Competition {
    @ToString.Exclude
    Integer id;
    String title;
    Integer maxCapacity;
    LocalDate registrationOpen;
    LocalDate registrationClose;
    LocalDate startDate;
    LocalDate endDate;
}
