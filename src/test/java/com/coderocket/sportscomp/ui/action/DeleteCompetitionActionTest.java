package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.dto.CompetitionContextHolder;
import com.coderocket.sportscomp.dto.DeleteCompetitionRequest;
import com.coderocket.sportscomp.ui.UserInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCompetitionActionTest {
    @Mock
    UserInput userInput;

    @Mock
    CompetitionService competitionService;

    @Mock
    CompetitionContextHolder competitionContextHolder;

    @InjectMocks
    DeleteCompetitionAction victim;

    @Captor
    private ArgumentCaptor<DeleteCompetitionRequest> captor;

    @Test
    void shouldReturnDeleteCompetitionAsActionName() {
        String expected = "Delete competition";
        String actual = victim.getName();

        assertEquals(expected, actual);
    }
    @Test
    void shouldCallCompetitionServiceToDeleteCompetition() {
        DeleteCompetitionRequest request = deleteCompetitionInRequest();
        when(userInput.getDeleteCompetitionRequest()).thenReturn(request);

        victim.execute();

        verify(userInput).getDeleteCompetitionRequest();
        verify(competitionService).deleteCompetition(request.getCompetition());
        verify(competitionContextHolder).clearChosenCompetition();
    }


    private DeleteCompetitionRequest deleteCompetitionInRequest() {
        DeleteCompetitionRequest request = new DeleteCompetitionRequest();

        request.setCompetition(competition());

        return request;
    }

    private Competition competition() {
        return Competition.builder()
                .title("test")
                .capacity(100)
                .registrationOpen(LocalDate.of(2022, 2, 2))
                .registrationClose(LocalDate.of(2022, 2, 2))
                .startDate(LocalDate.of(2022, 2, 2))
                .endDate(LocalDate.of(2022, 2, 2))
                .build();
    }

}