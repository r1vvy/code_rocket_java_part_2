package com.coderocket.sportscomp.in.action;

import com.coderocket.sportscomp.core.PlayerService;
import com.coderocket.sportscomp.in.UserInput;
import com.coderocket.sportscomp.in.converter.CreatePlayerInRequestToDomainConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePlayerAction implements MenuAction {

    private final UserInput userInput;
    private final PlayerService playerService;

    private final CreatePlayerInRequestToDomainConverter converter;

    @Override
    public String getName() {
        return "Create player";
    }

    @Override
    public void execute() {
        var request = userInput.getPlayerCreationRequest();
        var player = converter.convert(request);

        playerService.createPlayer(player);
    }
}
