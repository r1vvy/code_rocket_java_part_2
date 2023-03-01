package com.coderocket.sportscomp.core.ports.out.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface DeleteCompetitionPort {

    void delete(Competition competition);
}
