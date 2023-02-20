package com.coderocket.sportscomp.database.converter;

import com.coderocket.sportscomp.database.CompetitionEntity;
import com.coderocket.sportscomp.domain.Competition;
import org.springframework.stereotype.Component;

@Component
public class CompetitionDomainToCompetitionEntityConverter {
    public CompetitionEntity convert(Competition competition, Integer id) {
        return new CompetitionEntity(
                id,
                competition.getTitle(),
                competition.getMaxCapacity(),
                competition.getRegistrationOpen(),
                competition.getRegistrationClose(),
                competition.getStartDate(),
                competition.getEndDate()
        );
    }
}
