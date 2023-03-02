package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.request.competition.UpdateCompetitionInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateCompetitionInRequestToDomainConverter {

    public Competition convert(UpdateCompetitionInRequest updateCompetitionInRequest) {
        return Competition.builder()
                .title(updateCompetitionInRequest.title())
                .capacity(updateCompetitionInRequest.capacity())
                .registrationOpen(updateCompetitionInRequest.registrationOpen())
                .registrationClose(updateCompetitionInRequest.registrationClose())
                .startDate(updateCompetitionInRequest.startDate())
                .endDate(updateCompetitionInRequest.endDate())
                .build();
    }
}
