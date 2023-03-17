package com.coderocket.sportscomp.repository.adapter;

import com.coderocket.sportscomp.core.ports.out.SaveChuckNorrisJokePort;
import com.coderocket.sportscomp.domain.ChuckNorrisJoke;
import com.coderocket.sportscomp.repository.converter.ChuckNorrisJokeDomainToEntityConverter;
import com.coderocket.sportscomp.repository.converter.ChuckNorrisJokeEntityToDomainConverter;
import com.coderocket.sportscomp.repository.repository.ChuckNorrisJokeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveChuckNorrisJokeAdapter implements SaveChuckNorrisJokePort {
    private final ChuckNorrisJokeRepository chuckNorrisJokeRepository;
    private final ChuckNorrisJokeDomainToEntityConverter chuckNorrisJokeDomainToEntityConverter;
    private final ChuckNorrisJokeEntityToDomainConverter chuckNorrisJokeEntityToDomainConverter;

    @Override
    @Transactional
    public ChuckNorrisJoke save(ChuckNorrisJoke chuckNorrisJoke) {
        var entity = chuckNorrisJokeDomainToEntityConverter.convert(chuckNorrisJoke);
        var savedChuckNorrisJoke = chuckNorrisJokeRepository.save(entity);

        return chuckNorrisJokeEntityToDomainConverter.convert(savedChuckNorrisJoke);
    }
}
