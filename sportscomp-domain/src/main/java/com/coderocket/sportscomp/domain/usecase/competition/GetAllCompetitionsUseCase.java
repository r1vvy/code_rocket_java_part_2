package com.coderocket.sportscomp.domain.usecase.competition;

import com.coderocket.sportscomp.domain.Competition;

import java.util.List;

public interface GetAllCompetitionsUseCase {

    List<Competition> getAllCompetitions();
}
