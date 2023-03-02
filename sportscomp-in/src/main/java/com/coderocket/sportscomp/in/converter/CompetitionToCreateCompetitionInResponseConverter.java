package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.response.competition.CreateCompetitionInResponse;
import org.springframework.stereotype.Component;

@Component
public class CompetitionToCreateCompetitionInResponseConverter {

    public CreateCompetitionInResponse convert(Competition competition) {
        return new CreateCompetitionInResponse(
                competition.getId(),
                competition.getTitle(),
                competition.getCapacity(),
                competition.getRegistrationOpen(),
                competition.getRegistrationClose(),
                competition.getStartDate(),
                competition.getEndDate()
        );
    }
}
