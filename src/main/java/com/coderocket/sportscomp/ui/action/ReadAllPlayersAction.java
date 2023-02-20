package com.coderocket.sportscomp.ui.action;


import com.coderocket.sportscomp.core.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
    }
}
