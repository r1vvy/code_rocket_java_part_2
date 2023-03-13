package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.AddPlayerToCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.in.GetAllPlayersInCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.in.competition.*;
import com.coderocket.sportscomp.in.converter.*;
import com.coderocket.sportscomp.in.dto.request.AddPlayerToCompetitionRequest;
import com.coderocket.sportscomp.in.dto.request.competition.CreateCompetitionInRequest;
import com.coderocket.sportscomp.in.dto.request.competition.UpdateCompetitionInRequest;
import com.coderocket.sportscomp.in.dto.response.competition.CreateCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.DeleteCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.GetCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.UpdateCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.player.GetPlayerInResponse;
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
@RequestMapping("competitions")
public class CompetitionController {
    private final SaveCompetitionUseCase saveCompetitionUseCase;
    private final GetCompetitionUseCase getCompetitionUseCase;
    private final GetAllCompetitionsUseCase getAllCompetitionsUseCase;
    private final GetAllPlayersInCompetitionUseCase getAllPlayersInCompetitionUseCase;
    private final UpdateCompetitionUseCase updateCompetitionUseCase;
    private final DeleteCompetitionUseCase deleteCompetitionUseCase;

    private final AddPlayerToCompetitionUseCase addPlayerToCompetitionUseCase;


    private final CreateCompetitionInRequestToDomainConverter createCompetitionInRequestToDomainConverter;
    private final UpdateCompetitionInRequestToDomainConverter updateCompetitionInRequestToDomainConverter;
    private final AddPlayerToCompetitionInRequestToDomainConverter addPlayerToCompetitionInRequestToDomainConverter;


    private final CompetitionToCreateCompetitionInResponseConverter createCompetitionInResponseConverter;
    private final CompetitionToGetInResponseConverter competitionToGetInResponseConverter;
    private final CompetitionToUpdateCompetitionInResponseConverter competitionToUpdateCompetitionInResponseConverter;
    private final PlayerToGetPlayerInResponseConverter playerToGetPlayerInResponseConverter;

    @PostMapping("/")
    public ResponseEntity<CreateCompetitionInResponse> create(@RequestBody CreateCompetitionInRequest request) {
        var competition = createCompetitionInRequestToDomainConverter.convert(request);
        var createdCompetition = saveCompetitionUseCase.saveCompetition(competition);
        var responseBody = createCompetitionInResponseConverter.convert(createdCompetition);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);
    }

    @PutMapping("/{competitionId}/players")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayerToCompetition(@PathVariable Integer competitionId, @RequestBody AddPlayerToCompetitionRequest request) {
        var player = addPlayerToCompetitionInRequestToDomainConverter.convert(request);

        addPlayerToCompetitionUseCase.addPlayerToCompetitionByCompetitionId(player, competitionId);
    }

    @GetMapping("/{id}")
    public GetCompetitionInResponse findCompetitionById(@PathVariable Integer id) {
        var competition = getCompetitionUseCase.getCompetitionById(id);

        return competitionToGetInResponseConverter.convert(competition);
    }


    @GetMapping("/{id}/players")
    public List<GetPlayerInResponse> getAllPlayersInCompetition(@PathVariable Integer id) {

        return getAllPlayersInCompetitionUseCase.getAllPlayersInCompetitionByCompetitionId(id)
                .stream()
                .map(playerToGetPlayerInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    public List<GetCompetitionInResponse> getAllCompetitions() {
        return getAllCompetitionsUseCase.getAllCompetitions()
                .stream()
                .map(competitionToGetInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompetitionInResponse> update(@RequestBody UpdateCompetitionInRequest request, @PathVariable Integer id) {
           var competition = updateCompetitionInRequestToDomainConverter.convert(request);
           var updatedCompetition = updateCompetitionUseCase.update(competition, id);
           var responseBody = competitionToUpdateCompetitionInResponseConverter.convert(updatedCompetition);

           return ResponseEntity.ok().body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompetitionInResponse> deletePlayerById(@PathVariable Integer id) {
        deleteCompetitionUseCase.deleteCompetitionById(id);

        return ResponseEntity.noContent().build();
    }
}
