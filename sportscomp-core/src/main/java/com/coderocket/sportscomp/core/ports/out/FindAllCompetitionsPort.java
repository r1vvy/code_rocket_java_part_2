package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;

public interface FindAllCompetitionsPort {
    List<Competition> findAll();
}
