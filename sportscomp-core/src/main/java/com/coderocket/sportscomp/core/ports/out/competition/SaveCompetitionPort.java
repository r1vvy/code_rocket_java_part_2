package com.coderocket.sportscomp.core.ports.out.competition;

import com.coderocket.sportscomp.domain.Competition;

public interface SaveCompetitionPort {

    Competition save(Competition competition);
}
