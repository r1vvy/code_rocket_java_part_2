package com.coderocket.sportscomp.in.action.player;


import com.coderocket.sportscomp.core.ports.in.player.GetAllPlayersUseCase;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.in.action.MenuAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("readAllPlayersAction")
@AllArgsConstructor
public class ReadAllPlayersAction implements MenuAction {
    GetAllPlayersUseCase getAllPlayersUseCase;
    @Override
    public String getName() {
        return "View all players";
    }

    @Override
    public void execute() {
        var players = getAllPlayersUseCase.getAllPlayers();
        printAllPlayers(players);
    }

    private static void printAllPlayers(List<Player> players) {
        players.forEach(player -> System.out.println(player));
    }
}
