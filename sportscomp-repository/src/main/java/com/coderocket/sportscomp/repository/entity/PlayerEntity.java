package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "rating")
    Integer rating;

    @OneToMany(mappedBy = "playerEntity")
    Set<CompetitionPlayerEntity> competitions = new HashSet<>();
}
