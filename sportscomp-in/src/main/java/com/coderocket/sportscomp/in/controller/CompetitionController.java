package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.competition.GetCompetitionByIdUseCase;
import com.coderocket.sportscomp.core.ports.in.competition.SaveCompetitionUseCase;
import com.coderocket.sportscomp.in.converter.CompetitionToCreateCompetitionInResponseConverter;
import com.coderocket.sportscomp.in.converter.CompetitionToGetInResponseConverter;
import com.coderocket.sportscomp.in.converter.CreateCompetitionInRequestToDomainConverter;
import com.coderocket.sportscomp.in.dto.request.competition.CreateCompetitionInRequest;
import com.coderocket.sportscomp.in.dto.response.competition.CreateCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.GetCompetitionInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class CompetitionController {
    private final SaveCompetitionUseCase saveCompetitionUseCase;
    private final GetCompetitionByIdUseCase getCompetitionByIdUseCase;


    private final CreateCompetitionInRequestToDomainConverter createCompetitionInRequestToDomainConverter;
    private final CompetitionToCreateCompetitionInResponseConverter createCompetitionInResponseConverter;
    private final CompetitionToGetInResponseConverter competitionToGetInResponseConverter;

    @PostMapping("competitions/")
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

    @GetMapping("competitions/{id}")
    public GetCompetitionInResponse findCompetitionById(@PathVariable Integer id) {
        var competition = getCompetitionByIdUseCase.getCompetition(id);

        return competitionToGetInResponseConverter.convert(competition);
    }


}
