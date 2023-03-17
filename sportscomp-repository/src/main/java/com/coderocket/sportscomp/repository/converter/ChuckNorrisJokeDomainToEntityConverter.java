package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;
import com.coderocket.sportscomp.repository.entity.ChuckNorrisJokeEntity;
import org.springframework.stereotype.Component;

@Component
public class ChuckNorrisJokeDomainToEntityConverter {

    public ChuckNorrisJokeEntity convert(ChuckNorrisJoke chuckNorrisJoke) {
        return ChuckNorrisJokeEntity.builder()
                .url(chuckNorrisJoke.url())
                .content(chuckNorrisJoke.content())
                .build();
    }
}
