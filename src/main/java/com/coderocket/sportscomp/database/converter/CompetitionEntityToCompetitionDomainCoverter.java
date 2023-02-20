package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.CompetitionEntity;
import com.coderocket.sportscomp.domain.Competition;
import org.springframework.stereotype.Component;

@Component
public class CompetitionEntityToCompetitionDomainCoverter {

    public Competition convert(CompetitionEntity entity) {
        return Competition.builder()
                .title(entity.getTitle())
                .maxCapacity(entity.getMaxCapacity())
                .registrationOpen(entity.getRegistrationOpen())
                .registrationClose(entity.getRegistrationClose())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}
