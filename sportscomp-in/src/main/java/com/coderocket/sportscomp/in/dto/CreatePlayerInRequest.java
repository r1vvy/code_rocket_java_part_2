package com.coderocket.sportscomp.in.dto;

import lombok.Value;

@Value
public class CreatePlayerInRequest implements Request {
    String name;
    String surname;
    Integer rating;
}
