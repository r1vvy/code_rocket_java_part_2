package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Player;
import lombok.Data;

@Data
public class DeletePlayerRequest {
    Player player;
}
