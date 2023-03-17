package com.coderocket.sportscomp.out;

import com.coderocket.sportscomp.core.ports.out.GenerateRandomChuckNorrisJokePort;
import com.coderocket.sportscomp.domain.ChuckNorrisJoke;
import com.coderocket.sportscomp.out.converter.GetChuckNorrisOutResponseToDomainConverter;
import com.coderocket.sportscomp.out.dto.GetChuckNorrisOutResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@AllArgsConstructor
public class GenerateRandomChuckNorrisJokeAdapter implements GenerateRandomChuckNorrisJokePort {
    private final RestTemplate restTemplate;
    private final GetChuckNorrisOutResponseToDomainConverter chuckNorrisOutResponseToDomainConverter;

    @Override
    public ChuckNorrisJoke generate() {
        var response = restTemplate
                .getForEntity("https://api.chucknorris.io/jokes/random", GetChuckNorrisOutResponse.class)
                .getBody();
        log.debug("Chuck Norris made a random joke and sent it to our application as a request: {}", response);

        return chuckNorrisOutResponseToDomainConverter.convert(response);
    }
}
