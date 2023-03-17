package com.coderocket.sportscomp.repository.converter;


import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PlayerEntityToPlayerDomainConverter {
    private final ChuckNorrisJokeEntityToDomainConverter chuckNorrisJokeEntityToDomainConverter;

    public Player convert(PlayerEntity entity) {
        var builder = Player.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .rating(entity.getRating());

        Optional.ofNullable(entity.getChuckNorrisJokeEntity())
                .map(chuckNorrisJokeEntityToDomainConverter::convert)
                .ifPresent(builder::chuckNorrisJoke);

        return builder.build();
    }
}
