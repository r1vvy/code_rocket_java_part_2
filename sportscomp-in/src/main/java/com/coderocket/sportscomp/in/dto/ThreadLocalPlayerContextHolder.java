package com.coderocket.sportscomp.in.dto;

import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component("playerContextHolder")
@AllArgsConstructor
public class ThreadLocalPlayerContextHolder implements PlayerContextHolder{

    private final ThreadLocal<Player> chosenPlayer = new ThreadLocal<>();

    @Override
    public Player getChosenPlayer() {
        Player player = chosenPlayer.get();
        if (player == null) {
            throw new IllegalStateException("No competition has been set for this thread");
        }
        return player;
    }

    @Override
    public void setChosenPlayer(Player player) {
        chosenPlayer.set(player);
    }

    @Override
    public void clear() {
        chosenPlayer.remove();
    }
}
