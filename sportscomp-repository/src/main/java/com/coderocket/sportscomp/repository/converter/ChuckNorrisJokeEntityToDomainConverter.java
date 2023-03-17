package com.coderocket.sportscomp.repository.converter;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;
import com.coderocket.sportscomp.repository.entity.ChuckNorrisJokeEntity;
import org.springframework.stereotype.Component;

@Component
public class ChuckNorrisJokeEntityToDomainConverter {

    public ChuckNorrisJoke convert(ChuckNorrisJokeEntity entity) {
        return ChuckNorrisJoke.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .content(entity.getContent())
                .build();
    }
}
