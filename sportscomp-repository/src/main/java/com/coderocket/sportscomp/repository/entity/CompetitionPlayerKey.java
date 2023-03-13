package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompetitionPlayerKey implements Serializable {
    Integer playerEntityId;
    Integer competitionEntityId;

}
