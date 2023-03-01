package com.coderocket.sportscomp.core.ports.out.competition;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;

public interface FindAllCompetitionsPort {
    List<Competition> findAll();
}
