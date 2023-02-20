package com.coderocket.sportscomp.domain;


import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString(doNotUseGetters = true)
public class Player {

    @ToString.Exclude
    Integer id;
    String name;
    String surname;
    Integer rating;

}
