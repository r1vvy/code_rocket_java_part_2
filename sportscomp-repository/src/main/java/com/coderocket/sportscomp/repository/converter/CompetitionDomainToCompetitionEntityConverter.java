package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.CompetitionEntity;
import org.springframework.stereotype.Component;

@Component
public class CompetitionDomainToCompetitionEntityConverter {
    public CompetitionEntity convert(Competition competition) {
        return CompetitionEntity.builder()
                .title(competition.getTitle())
                .capacity(competition.getCapacity())
                .registrationOpen(competition.getRegistrationOpen())
                .registrationClose(competition.getRegistrationClose())
                .startDate(competition.getStartDate())
                .endDate(competition.getEndDate())
                .build();
    }
}
