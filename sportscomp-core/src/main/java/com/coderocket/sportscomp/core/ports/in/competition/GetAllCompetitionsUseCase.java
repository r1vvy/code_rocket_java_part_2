package com.coderocket.sportscomp.core.ports.in.competition;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;

public interface GetAllCompetitionsUseCase {

    List<Competition> getAllCompetitions();
}
