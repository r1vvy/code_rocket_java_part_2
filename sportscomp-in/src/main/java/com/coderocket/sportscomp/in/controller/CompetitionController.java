package com.coderocket.sportscomp.in.controller;

import com.coderocket.sportscomp.core.ports.in.competition.DeleteCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.in.competition.GetCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.in.competition.SaveCompetitionUseCase;
import com.coderocket.sportscomp.core.ports.in.competition.UpdateCompetitionUseCase;
import com.coderocket.sportscomp.in.converter.*;
import com.coderocket.sportscomp.in.dto.request.competition.CreateCompetitionInRequest;
import com.coderocket.sportscomp.in.dto.request.competition.UpdateCompetitionInRequest;
import com.coderocket.sportscomp.in.dto.response.competition.CreateCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.DeleteCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.GetCompetitionInResponse;
import com.coderocket.sportscomp.in.dto.response.competition.UpdateCompetitionInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping("competitions")
public class CompetitionController {
    private final SaveCompetitionUseCase saveCompetitionUseCase;
    private final GetCompetitionUseCase getCompetitionUseCase;
    private final UpdateCompetitionUseCase updateCompetitionUseCase;
    private final DeleteCompetitionUseCase deleteCompetitionUseCase;


    private final CreateCompetitionInRequestToDomainConverter createCompetitionInRequestToDomainConverter;
    private final UpdateCompetitionInRequestToDomainConverter updateCompetitionInRequestToDomainConverter;

    private final CompetitionToCreateCompetitionInResponseConverter createCompetitionInResponseConverter;
    private final CompetitionToGetInResponseConverter competitionToGetInResponseConverter;
    private final CompetitionToUpdateCompetitionInResponseConverter competitionToUpdateCompetitionInResponseConverter;

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

    @GetMapping("/{id}")
    public GetCompetitionInResponse findCompetitionById(@PathVariable Integer id) {
        var competition = getCompetitionUseCase.getCompetitionById(id);

        return competitionToGetInResponseConverter.convert(competition);
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
