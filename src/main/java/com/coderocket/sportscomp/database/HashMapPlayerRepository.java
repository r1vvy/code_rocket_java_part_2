package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class HashMapPlayerRepository implements PlayerRepository {
    private static Integer PLAYER_SEQUENCE = 1;
    private Map<Integer, PlayerEntity> repo = new HashMap<>();

    private final PlayerDomainToPlayerEntityConverter converter;

    @Override
    public void save(Player player) {
        PlayerEntity entity = converter.convert(player, ++PLAYER_SEQUENCE);
        repo.put(entity.getId(), entity);
    }
}
