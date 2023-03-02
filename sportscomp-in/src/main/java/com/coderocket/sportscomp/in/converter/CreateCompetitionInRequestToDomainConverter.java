package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.request.competition.CreateCompetitionInRequest;
import com.coderocket.sportscomp.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class CreateCompetitionInRequestToDomainConverter {
    public Competition convert(CreateCompetitionInRequest request) {
        return Competition.builder()
                .title(request.title())
                .capacity(request.capacity())
                .registrationOpen(DateTimeUtils.formatStringAsLocalDate(request.registrationOpen()))
                .registrationClose(DateTimeUtils.formatStringAsLocalDate(request.registrationClose()))
                .startDate(DateTimeUtils.formatStringAsLocalDate(request.startDate()))
                .endDate(DateTimeUtils.formatStringAsLocalDate(request.endDate()))
                .build();
    }
}
