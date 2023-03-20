package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionPlayerKey implements Serializable {
    Integer playerEntityId;
    Integer competitionEntityId;
}
