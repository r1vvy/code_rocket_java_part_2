package com.coderocket.sportscomp.core.ports.out.competition;

import com.coderocket.sportscomp.domain.Competition;

import java.util.Optional;

public interface FindCompetitionByIdPort {
    Optional<Competition> findById(Integer id);
}
