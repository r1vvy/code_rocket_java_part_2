package com.coderocket.sportscomp.in.action.player;

import com.coderocket.sportscomp.core.ports.in.player.SavePlayerUseCase;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.converter.CreatePlayerInRequestToDomainConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("createPlayerAction")
@RequiredArgsConstructor
public class CreatePlayerAction implements MenuAction {

    private final UserInput userInput;
    private final CreatePlayerInRequestToDomainConverter converter;

    private final SavePlayerUseCase savePlayerUseCase;

    @Override
    public String getName() {
        return "Create player";
    }

    @Override
    public void execute() {
        var request = userInput.getCreatePlayerRequest();
        var player = converter.convert(request);
        savePlayerUseCase.savePlayer(player);
    }
}
