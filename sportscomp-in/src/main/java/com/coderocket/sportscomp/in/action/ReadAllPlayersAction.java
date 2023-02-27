package com.coderocket.sportscomp.in.action;


import com.coderocket.sportscomp.core.PlayerService;
import com.coderocket.sportscomp.domain.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReadAllPlayersAction implements MenuAction {
    private final PlayerService playerService;

    @Override
    public String getName() {
        return "View all players";
    }

    @Override
    public void execute() {
        var players = playerService.getAllPlayers();
        // TODO: Add validation
        printAllPlayers(players);
    }

    private static void printAllPlayers(List<Player> players) {
        players.forEach(player -> System.out.println(player));
    }
}
