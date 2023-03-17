package com.coderocket.sportscomp.repository.converter;


import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerDomainToPlayerEntityConverter {

    private final ChuckNorrisJokeDomainToEntityConverter chuckNorrisJokeDomainToEntityConverter;

    public PlayerEntity convert(Player player) {
        var chuckNorrisJokeEntity = chuckNorrisJokeDomainToEntityConverter.convert(player.getChuckNorrisJoke());

        return PlayerEntity.builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .rating(player.getRating())
                .chuckNorrisJokeEntity(chuckNorrisJokeEntity)
                .build();


    }
}
