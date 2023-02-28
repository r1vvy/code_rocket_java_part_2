package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Player;

public interface PlayerContextHolder extends ContextHolder{
    Player getChosenPlayer();
    void setChosenPlayer(Player player);
}
