package com.coderocket.sportscomp.dto;

import lombok.Value;

@Value
public class ReadCompetitionByIdInRequest implements Request {
    Integer id;
}
