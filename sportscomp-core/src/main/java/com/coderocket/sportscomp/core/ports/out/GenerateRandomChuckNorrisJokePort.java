package com.coderocket.sportscomp.core.ports.out;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;

public interface GenerateRandomChuckNorrisJokePort {

    ChuckNorrisJoke generate();
}
