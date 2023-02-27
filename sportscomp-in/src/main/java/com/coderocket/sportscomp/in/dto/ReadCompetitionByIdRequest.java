package com.coderocket.sportscomp.in.dto;

import lombok.Value;

@Value
public class ReadCompetitionByIdRequest implements Request {
    Integer id;
}
