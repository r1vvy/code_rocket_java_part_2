package com.coderocket.sportscomp.in.dto;

import lombok.Value;

@Value
public class CreatePlayerInRequest {
    String name;
    String surname;
    Integer rating;
}
