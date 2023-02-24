package com.coderocket.sportscomp.dto;

import com.coderocket.sportscomp.domain.Competition;
import lombok.Value;

@Value
public class DeleteCompetitionInActionRequest implements Request {
    Competition competition;
}
