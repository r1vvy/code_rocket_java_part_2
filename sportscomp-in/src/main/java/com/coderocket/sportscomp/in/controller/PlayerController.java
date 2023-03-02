package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.player.DeletePlayerUseCase;
import com.coderocket.sportscomp.core.ports.in.player.GetPlayerUseCase;
import com.coderocket.sportscomp.core.ports.in.player.SavePlayerUseCase;
import com.coderocket.sportscomp.in.converter.CreatePlayerInRequestToDomainConverter;
import com.coderocket.sportscomp.in.converter.PlayerToCreatePlayerInResponseConverter;
import com.coderocket.sportscomp.in.converter.PlayerToGetPlayerInResponseConverter;
import com.coderocket.sportscomp.in.dto.request.player.CreatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.response.player.CreatePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.DeletePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class PlayerController {
    private final SavePlayerUseCase savePlayerUseCase;
    private final GetPlayerUseCase getPlayerUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;

    private final CreatePlayerInRequestToDomainConverter createPlayerInRequestToDomainConverter;
    private final PlayerToCreatePlayerInResponseConverter playerToCreatePlayerInResponseConverter;
    private final PlayerToGetPlayerInResponseConverter playerToGetPlayerInResponseConverter;

    @PostMapping("/players")
    public ResponseEntity<CreatePlayerInResponse>  create(@RequestBody CreatePlayerInRequest request) {
        var player = createPlayerInRequestToDomainConverter.convert(request);
        var createdPlayer = savePlayerUseCase.savePlayer(player);
        var responseBody = playerToCreatePlayerInResponseConverter.convert(createdPlayer);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);
    }

    @GetMapping("/players/{id}")
    public GetPlayerInResponse findPlayerById(@PathVariable Integer id) {
        var player = getPlayerUseCase.getPlayer(id);

        return playerToGetPlayerInResponseConverter.convert(player);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<DeletePlayerInResponse> deletePlayerById(@PathVariable Integer id) {
        deletePlayerUseCase.deletePlayerById(id);

        return ResponseEntity.noContent().build();
    }
}
