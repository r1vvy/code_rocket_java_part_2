package com.coderocket.sportscomp.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "competitions")
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "title")
    String title;
    @Column(name = "capacity")
    Integer capacity;
    @Column(name = "registration_open_date")
    LocalDate registrationOpen;
    @Column(name = "registration_close_date")
    LocalDate registrationClose;
    @Column(name = "start_date")
    LocalDate startDate;
    @Column(name = "end_date")
    LocalDate endDate;

    @OneToMany(mappedBy = "competitionEntity")
    private Set<CompetitionPlayerEntity> players = new HashSet<>();
}
