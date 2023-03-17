package com.coderocket.sportscomp.in.converter;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.dto.response.player.UpdatePlayerInResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerToUpdatePlayerInResponseConverter {

    public UpdatePlayerInResponse convert(Player player) {
        return new UpdatePlayerInResponse(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getRating(),
                player.getChuckNorrisJoke()
        );
    }
}
