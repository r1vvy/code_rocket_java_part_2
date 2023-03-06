package com.coderocket.sportscomp.repository.adapter.player;

import com.coderocket.sportscomp.core.ports.out.player.FindAllPlayersPort;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import com.coderocket.sportscomp.repository.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class FindAllPlayersAdapter implements FindAllPlayersPort {
    private final PlayerRepository playerRepository;
    private final PlayerEntityToPlayerDomainConverter playerEntityToPlayerDomainConverter;

    @Override
    public List<Player> findAll() {
        Iterable<PlayerEntity> iterable = playerRepository.findAll();

        return StreamSupport.stream(iterable.spliterator(), false)
                .map(playerEntityToPlayerDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
