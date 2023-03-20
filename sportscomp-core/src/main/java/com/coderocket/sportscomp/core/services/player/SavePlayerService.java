package com.coderocket.sportscomp.core.services.player;

import com.coderocket.sportscomp.core.ports.out.GenerateRandomChuckNorrisJokePort;
import com.coderocket.sportscomp.core.ports.out.SaveChuckNorrisJokePort;
import com.coderocket.sportscomp.core.ports.out.player.SavePlayerPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.core.ports.in.player.SavePlayerUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SavePlayerService implements SavePlayerUseCase {
    private final SavePlayerPort savePlayerPort;
    private final SaveChuckNorrisJokePort saveChuckNorrisJokePort;
    private final GenerateRandomChuckNorrisJokePort generateRandomChuckNorrisJokePort;

    @Override
    public Player savePlayer(Player player) {
        var generatedChuckNorrisJoke = generateRandomChuckNorrisJokePort.generate();
        log.debug("Chuck Norris generated a new joke: {}", generatedChuckNorrisJoke);
        var savedChuckNorrisJoke = saveChuckNorrisJokePort.save(generatedChuckNorrisJoke);

        var playerWithChuckNorrisJoke = player.toBuilder()
                .chuckNorrisJoke(savedChuckNorrisJoke)
                .build();

        return savePlayerPort.save(playerWithChuckNorrisJoke);
    }
}
