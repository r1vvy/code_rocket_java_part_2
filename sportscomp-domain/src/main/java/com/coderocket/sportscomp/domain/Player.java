package com.coderocket.sportscomp.domain;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Player {
    Integer id;
    String firstName;
    String lastName;
    Integer rating;

}
