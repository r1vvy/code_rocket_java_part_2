package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerToGetPlayerInResponseConverter {

    public GetPlayerInResponse convert(Player player) {
        return new GetPlayerInResponse(
                player.getId(),
                player.getName(),
                player.getSurname(),
                player.getRating()
        );
    }
}
