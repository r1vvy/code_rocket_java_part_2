package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.dto.CompetitionContextHolder;
import com.coderocket.sportscomp.dto.ReadCompetitionByIdRequest;
import com.coderocket.sportscomp.ui.UserInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReadCompetitionActionTest {
    @Mock
    UserInput userInput;

    @Mock
    CompetitionService competitionService;

    @Mock
    CompetitionContextHolder contextHolder;

    @Mock
    List<MenuAction> competitionSubActions;

    @InjectMocks
    ReadCompetitionAction victim;

    @Test
    void shouldReturnReadCompetitionAsActionName() {
        String expected = "Read competition";
        String actual = victim.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetSubActions() {
        List<MenuAction> subActions = victim.getSubActions();
        assertEquals(competitionSubActions, subActions);
    }

    @Test
    void shouldExecute() {
        // Set up the test data and mocks
        ReadCompetitionByIdRequest request = new ReadCompetitionByIdRequest(1);
        Competition competition = competition();
        when(userInput.getReadCompetitionByIdRequest()).thenReturn(request);
        when(competitionService.getCompetitionById(request.getId())).thenReturn(competition);

        // Call the method being tested
        victim.execute();

        // Verify that the expected methods were called
        verify(userInput).getReadCompetitionByIdRequest();
        verify(competitionService).getCompetitionById(request.getId());
        verify(contextHolder).setChosenCompetition(competition);

        when(contextHolder.getChosenCompetition()).thenReturn(competition);

        // Verify that the CompetitionContextHolder was set with the correct competition
        assertEquals(competition, contextHolder.getChosenCompetition());
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