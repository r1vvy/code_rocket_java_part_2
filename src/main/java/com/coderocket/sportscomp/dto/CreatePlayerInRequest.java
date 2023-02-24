package com.coderocket.sportscomp.dto;

import lombok.Value;

@Value
public class CreatePlayerInRequest implements Request{
    String name;
    String surname;
}
