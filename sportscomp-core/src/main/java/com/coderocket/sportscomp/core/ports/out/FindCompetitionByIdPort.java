package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Competition;

import java.util.Optional;

public interface FindCompetitionByIdPort {
    Optional<Competition> findById(Integer id);
}
