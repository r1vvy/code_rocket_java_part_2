package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.database.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class HashMapPlayerRepository implements PlayerRepository {
    private static Integer PLAYER_SEQUENCE = 1;
    private Map<Integer, PlayerEntity> repo = new HashMap<>();

    private final PlayerDomainToPlayerEntityConverter domainToEntityConverter;
    private final PlayerEntityToPlayerDomainConverter entityToDomainConverter;

    @Override
    public void save(Player player) {
        PlayerEntity entity = domainToEntityConverter.convert(player, ++PLAYER_SEQUENCE);
        repo.put(entity.getId(), entity);
    }

    @Override
    public Stream<Player> getAllPlayers() {
        return repo.values()
                .stream()
                .map(entityToDomainConverter::convert);
    }
}
