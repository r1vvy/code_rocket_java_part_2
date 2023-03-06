package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.player.*;
import com.coderocket.sportscomp.in.converter.*;
import com.coderocket.sportscomp.in.dto.request.player.CreatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.request.player.UpdatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.response.player.CreatePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.UpdatePlayerInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("players")
public class PlayerController {
    private final SavePlayerUseCase savePlayerUseCase;
    private final GetPlayerUseCase getPlayerUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;
    private final GetAllPlayersUseCase getAllPlayersUseCase;

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

    @GetMapping("/")
    public List<GetPlayerInResponse> getAllPlayers() {
        return getAllPlayersUseCase.getAllPlayers()
                .stream()
                .map(playerToGetPlayerInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePlayerInResponse> update(@RequestBody UpdatePlayerInRequest request, @PathVariable Integer id) {
        var player = updatePlayerInRequestToDomainConverter.convert(request);
        var updatedPlayer = updatePlayerUseCase.updatePlayer(player, id);
        var responseBody = playerToUpdatePlayerInResponseConverter.convert(updatedPlayer);

        return ResponseEntity.ok().body(responseBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayerById(@PathVariable Integer id) {
        deletePlayerUseCase.deletePlayerById(id);
    }
}
