package com.coderocket.sportscomp.in.dto.request.competition;


import com.coderocket.sportscomp.domain.Competition;
import lombok.Data;

@Data
public class DeleteCompetitionInRequest {
    Competition competition;
}
