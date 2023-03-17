package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;

public interface SaveChuckNorrisJokePort {

    ChuckNorrisJoke save(ChuckNorrisJoke chuckNorrisJoke);
}
