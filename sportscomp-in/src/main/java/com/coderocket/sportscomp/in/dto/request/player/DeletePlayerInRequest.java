package com.coderocket.sportscomp.in.dto.request.player;

import com.coderocket.sportscomp.domain.Player;
import lombok.Data;

@Data
public class DeletePlayerInRequest {
    Player player;
}
