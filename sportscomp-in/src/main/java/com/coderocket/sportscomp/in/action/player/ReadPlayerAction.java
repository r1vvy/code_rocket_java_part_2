package com.coderocket.sportscomp.in.action.player;

import com.coderocket.sportscomp.core.ports.in.player.GetPlayerUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.action.MenuActionWithSubActions;
import com.coderocket.sportscomp.in.dto.PlayerContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("readPlayerAction")
@RequiredArgsConstructor
public class ReadPlayerAction implements MenuActionWithSubActions {

    private final UserInput userInput;
    private final GetPlayerUseCase getPlayerUseCase;


    @Autowired
    @Qualifier("playerContextHolder")
    private PlayerContextHolder contextHolder;

    @Autowired
    @Qualifier("playerSubActions")
    private List<MenuAction> playerSubActions;

    @Override
    public String getName() {
        return "Read player";
    }

    @Override
    public void execute() {
        var request = userInput.getPlayerReadRequest();
        var player = getPlayerUseCase.getPlayer(request.getId());

        contextHolder.setChosenPlayer(player);

        System.out.println("Player: " + player.toString());
    }

    @Override
    public List<MenuAction> getSubActions() {
        return playerSubActions;
    }
}
