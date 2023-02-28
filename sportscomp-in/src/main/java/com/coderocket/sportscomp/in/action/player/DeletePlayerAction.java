package com.coderocket.sportscomp.in.action.player;

import com.coderocket.sportscomp.core.ports.in.player.DeletePlayerUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.dto.PlayerContextHolder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("deletePlayerAction")
@AllArgsConstructor
public class DeletePlayerAction implements MenuAction {
    private final UserInput userInput;
    private final DeletePlayerUseCase deletePlayerUseCase;

    @Autowired
    @Qualifier("playerContextHolder")
    private PlayerContextHolder contextHolder;

    @Override
    public String getName() {
        return "Delete player";
    }

    @Override
    public void execute() {
        var request = userInput.getDeletePlayerRequest();
        deletePlayerUseCase.deletePlayer(request.getPlayer());

        contextHolder.clear();
    }
}
