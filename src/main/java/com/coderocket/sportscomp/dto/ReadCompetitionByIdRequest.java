package com.coderocket.sportscomp.dto;

import lombok.Value;

@Value
public class ReadCompetitionByIdRequest implements Request {
    Integer id;
}
