package com.coderocket.sportscomp.ui;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.ui.action.ReadAllCompetitionsAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ReadAllCompetitionsActionTest {
    @Mock
    private UserInput userInput;
    @Mock
    private CompetitionService competitionService;
    @InjectMocks
    private ReadAllCompetitionsAction victim;

    @Mock
    private Competition competition;

    @Test
    void shouldReturnViewAllCompetitionsAsActionName() {
        String expected = "View all competitions";
        String actual = victim.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallCompetitionServiceToReturnAllCompetitions() {
    }


}