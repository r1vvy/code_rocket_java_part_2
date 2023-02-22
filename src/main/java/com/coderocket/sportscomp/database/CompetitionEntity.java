package com.coderocket.sportscomp.database;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
}
