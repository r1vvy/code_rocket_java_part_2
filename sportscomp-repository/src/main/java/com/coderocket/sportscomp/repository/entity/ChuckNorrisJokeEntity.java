package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "chuck_norris_jokes")
@AllArgsConstructor
@NoArgsConstructor
public class ChuckNorrisJokeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String url;

    @Column
    String content;
}
