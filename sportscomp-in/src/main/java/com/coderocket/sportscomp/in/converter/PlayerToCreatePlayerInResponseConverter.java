package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.response.player.CreatePlayerInResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerToCreatePlayerInResponseConverter {

    public CreatePlayerInResponse convert(Player player) {

        return new CreatePlayerInResponse(
                player.getId(),
                player.getName(),
                player.getSurname(),
                player.getRating()
        );
    }
}
