package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.player.DeletePlayerUseCase;
import com.coderocket.sportscomp.core.ports.in.player.GetPlayerUseCase;
import com.coderocket.sportscomp.core.ports.in.player.SavePlayerUseCase;
import com.coderocket.sportscomp.core.ports.in.player.UpdatePlayerUseCase;
import com.coderocket.sportscomp.in.converter.*;
import com.coderocket.sportscomp.in.dto.request.player.CreatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.request.player.UpdatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.response.player.CreatePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.DeletePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.UpdatePlayerInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping("players")
public class PlayerController {
    private final SavePlayerUseCase savePlayerUseCase;
    private final GetPlayerUseCase getPlayerUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;

    private final UpdatePlayerInRequestToDomainConverter updatePlayerInRequestToDomainConverter;
    private final CreatePlayerInRequestToDomainConverter createPlayerInRequestToDomainConverter;


    private final PlayerToCreatePlayerInResponseConverter playerToCreatePlayerInResponseConverter;
    private final PlayerToGetPlayerInResponseConverter playerToGetPlayerInResponseConverter;
    private final PlayerToUpdatePlayerInResponseConverter playerToUpdatePlayerInResponseConverter;

    @PostMapping("/")
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

    @GetMapping("/{id}")
    public GetPlayerInResponse findPlayerById(@PathVariable Integer id) {
        var player = getPlayerUseCase.getPlayer(id);

        return playerToGetPlayerInResponseConverter.convert(player);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdatePlayerInResponse> update(@RequestBody UpdatePlayerInRequest request, @PathVariable Integer id) {
        var player = updatePlayerInRequestToDomainConverter.convert(request);
        var updatedPlayer = updatePlayerUseCase.updatePlayer(player, id);
        var responseBody = playerToUpdatePlayerInResponseConverter.convert(updatedPlayer);

        return ResponseEntity.ok().body(responseBody);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeletePlayerInResponse> deletePlayerById(@PathVariable Integer id) {
        deletePlayerUseCase.deletePlayerById(id);

        return ResponseEntity.noContent().build();
    }
}
