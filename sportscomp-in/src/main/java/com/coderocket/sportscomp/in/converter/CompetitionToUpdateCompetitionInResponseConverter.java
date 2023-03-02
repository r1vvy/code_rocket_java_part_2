package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.response.competition.UpdateCompetitionInResponse;
import org.springframework.stereotype.Component;

@Component
public class CompetitionToUpdateCompetitionInResponseConverter {

    public UpdateCompetitionInResponse convert(Competition competition) {

        return new UpdateCompetitionInResponse(
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
