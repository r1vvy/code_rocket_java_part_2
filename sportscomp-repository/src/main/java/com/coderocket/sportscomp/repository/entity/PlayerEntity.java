package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "rating")
    Integer rating;

    @OneToOne
    @JoinColumn(name = "joke_id", referencedColumnName = "id")
    ChuckNorrisJokeEntity chuckNorrisJokeEntity;

}
