package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.request.competition.CreateCompetitionInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCompetitionInRequestToDomainConverter {
    public Competition convert(CreateCompetitionInRequest request) {
        return Competition.builder()
                .title(request.getTitle())
                .capacity(request.getCapacity())
                .registrationOpen(request.getRegistrationOpen())
                .registrationClose(request.getRegistrationClose())
                .startDate(request.getStartDate())
                .endDate((request.getEndDate()))
                .build();
    }
}
