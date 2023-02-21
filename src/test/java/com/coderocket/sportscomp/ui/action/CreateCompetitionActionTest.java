package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.CompetitionService;
import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.dto.CreateCompetitionInRequest;
import com.coderocket.sportscomp.ui.UserInput;
import com.coderocket.sportscomp.ui.converter.CreateCompetitionInRequestToDomainConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCompetitionActionTest {
    @Mock
    private UserInput userInput;
    @Mock
    private CompetitionService competitionService;
    @Mock
    private CreateCompetitionInRequestToDomainConverter converter;
    @Captor
    private ArgumentCaptor<CreateCompetitionInRequest> captor;

    @InjectMocks
    private CreateCompetitionAction victim;

    @Test
    void shouldReturnCreateCompetitionAsActionName() {
        String expected = "Create competition";
        String actual = victim.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallCompetitionServiceToCreateACompetition() {
        CreateCompetitionInRequest request = createCompetitionInRequest();

        when(userInput.getCompetitionCreationRequest()).thenReturn(request);
        when(converter.convert(request)).thenReturn(competition());

        victim.execute();

        verify(userInput).getCompetitionCreationRequest();
        verify(converter).convert(captor.capture());

        CreateCompetitionInRequest capturedRequest = captor.getValue();

        assertNotNull(capturedRequest);
        assertEquals("Test", capturedRequest.getTitle());
        assertEquals(LocalDate.of(2022, 10, 22), capturedRequest.getRegistrationOpen());

        verify(competitionService).createCompetition(competition());
    }

    private CreateCompetitionInRequest createCompetitionInRequest() {
        return new CreateCompetitionInRequest(
            "Test",
            100,
                LocalDate.of(2022, 10, 22),
                LocalDate.of(2022, 10, 22),
                LocalDate.of(2022, 10, 22),
                LocalDate.of(2022, 10, 22)
        );
    }
    private Competition competition() {
        return Competition.builder()
                .title("Test")
                .capacity(100)
                .registrationOpen(LocalDate.of(2022, 10, 22))
                .registrationClose(LocalDate.of(2022, 10, 22))
                .startDate(LocalDate.of(2022, 10, 22))
                .endDate(LocalDate.of(2022, 10, 22))
                .build();
    }
}
