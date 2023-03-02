package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.in.dto.response.competition.GetCompetitionInResponse;
import org.springframework.stereotype.Component;

@Component
public class CompetitionToGetInResponseConverter {

    public GetCompetitionInResponse convert(Competition competition) {
        return new GetCompetitionInResponse(
                competition.getId(),
                competition.getTitle(),
                competition.getCapacity(),
                competition.getRegistrationOpen().toString(),
                competition.getRegistrationClose().toString(),
                competition.getStartDate().toString(),
                competition.getEndDate().toString()
        );
    }
}
