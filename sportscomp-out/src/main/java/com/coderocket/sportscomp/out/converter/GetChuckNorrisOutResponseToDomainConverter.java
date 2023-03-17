package com.coderocket.sportscomp.out.converter;

import com.coderocket.sportscomp.domain.ChuckNorrisJoke;
import com.coderocket.sportscomp.out.dto.GetChuckNorrisOutResponse;
import org.springframework.stereotype.Component;

@Component
public class GetChuckNorrisOutResponseToDomainConverter {

    public ChuckNorrisJoke convert(GetChuckNorrisOutResponse response) {
        return ChuckNorrisJoke.builder()
                .url(response.url())
                .content(response.value())
                .build();
    }
}
