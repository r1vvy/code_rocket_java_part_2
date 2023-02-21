package com.coderocket.sportscomp.ui.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.dto.CreateCompetitionInRequest;
import com.coderocket.sportscomp.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class CreateCompetitionInRequestToDomainConverter {
    private DateTimeUtils dateTimeUtils = new DateTimeUtils();
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
