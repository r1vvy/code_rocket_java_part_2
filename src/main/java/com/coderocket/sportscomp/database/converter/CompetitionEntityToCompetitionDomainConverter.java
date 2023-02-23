package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.CompetitionEntity;
import com.coderocket.sportscomp.domain.Competition;
import org.springframework.stereotype.Component;

@Component
public class CompetitionEntityToCompetitionDomainConverter {

    public Competition convert(CompetitionEntity entity) {
        return Competition.builder()
                .title(entity.getTitle())
                .capacity(entity.getCapacity())
                .registrationOpen(entity.getRegistrationOpen())
                .registrationClose(entity.getRegistrationClose())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .id(entity.getId())
                .build();
    }
}
