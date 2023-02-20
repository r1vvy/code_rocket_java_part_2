package com.coderocket.sportscomp.database;

import lombok.Value;

@Value
public class PlayerEntity {
    Integer id;
    String name;
    String surname;
    Integer rating;


}
