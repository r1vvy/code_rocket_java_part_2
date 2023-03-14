package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.player.*;
import com.coderocket.sportscomp.in.converter.*;
import com.coderocket.sportscomp.in.dto.request.player.CreatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.request.player.UpdatePlayerInRequest;
import com.coderocket.sportscomp.in.dto.response.player.CreatePlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
import com.coderocket.sportscomp.in.dto.response.player.UpdatePlayerInResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/players")
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
    public ResponseEntity<CreatePlayerInResponse> create(@RequestBody CreatePlayerInRequest request) {
        log.debug("Recieved create player request: {}", request);

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
        log.debug("Recieved find player by player id request: {}", id);

        var player = getPlayerUseCase.getPlayer(id);

        return playerToGetPlayerInResponseConverter.convert(player);
    }

    @GetMapping("/")
    public List<GetPlayerInResponse> getAllPlayers() {
        log.debug("Recieved get all players request");

        return getAllPlayersUseCase.getAllPlayers()
                .stream()
                .map(playerToGetPlayerInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePlayerInResponse> update(@RequestBody UpdatePlayerInRequest request, @PathVariable Integer id) {
        log.debug("Recieved update player by player id request: {}, {}", id, request);

        var player = updatePlayerInRequestToDomainConverter.convert(request);
        var updatedPlayer = updatePlayerUseCase.updatePlayer(player, id);
        var responseBody = playerToUpdatePlayerInResponseConverter.convert(updatedPlayer);

        return ResponseEntity.ok().body(responseBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayerById(@PathVariable Integer id) {
        log.debug("Recieved delete player by player id request: {}", id);

        deletePlayerUseCase.deletePlayerById(id);
    }
}
