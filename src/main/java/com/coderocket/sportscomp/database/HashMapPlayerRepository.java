package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.database.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.domain.Player;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class HashMapPlayerRepository implements PlayerRepository {
    private static Integer PLAYER_SEQUENCE = 1;
    private Map<Integer, PlayerEntity> repo = new HashMap<>();

    private final PlayerDomainToPlayerEntityConverter domainToEntityConverter;
    private final PlayerEntityToPlayerDomainConverter entityToDomainConverter;

    @Override
    public void save(Player player) {
        PlayerEntity entity = domainToEntityConverter.convert(player);
        entity.setId(PLAYER_SEQUENCE++);
        repo.put(entity.getId(), entity);
    }

    @Override
    public List<Player> findAllPlayers() {
        return repo.values()
                .stream()
                .map(entityToDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
