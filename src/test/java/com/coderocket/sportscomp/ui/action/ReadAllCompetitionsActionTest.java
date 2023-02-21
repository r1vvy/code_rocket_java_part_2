package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ReadAllCompetitionsActionTest {
    @Mock
    private CompetitionService competitionService;

    @Test
    void shouldReturnViewAllCompetitionsAsActionName() {
        ReadAllCompetitionsAction victim = new ReadAllCompetitionsAction(competitionService);

        String actual = victim.getName();
        String expected = "View all competitions";

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallCompetitionServiceToReturnCompetition() {
        // arrange
        ArrayList<Competition> competitions = new ArrayList<>();
        competitions.add(competition());
        competitions.add(competition());
        when(competitionService.getAllCompetitionsAsArrayList()).thenReturn(competitions);

        // act
        ReadAllCompetitionsAction victim = new ReadAllCompetitionsAction(competitionService);
        victim.execute();

        // assert
        verify(competitionService, times(1)).getAllCompetitionsAsArrayList();
    }


    private Competition competition() {
        return Competition.builder()
                .title("Test")
                .capacity(20)
                .registrationOpen(LocalDate.now())
                .registrationClose(LocalDate.now())
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();
    }
}