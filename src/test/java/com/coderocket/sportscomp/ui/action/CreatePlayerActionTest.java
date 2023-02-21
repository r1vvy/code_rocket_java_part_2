package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.PlayerService;
import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.dto.CreatePlayerInRequest;
import com.coderocket.sportscomp.ui.UserInput;
import com.coderocket.sportscomp.ui.converter.CreatePlayerInRequestToDomainConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePlayerActionTest {

    @Mock
    UserInput userInput;
    @Mock
    PlayerService playerService;
    @Mock
    CreatePlayerInRequestToDomainConverter converter;
    @Captor
    private ArgumentCaptor<CreatePlayerInRequest> captor;
    @InjectMocks
    CreatePlayerAction victim;

    @Test
    void shouldReturnCreateUserAsActionName() {
        String expected = "Create player";
        String actual = victim.getName();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallPlayerServiceToCreatePlayer() {
        CreatePlayerInRequest request = createPlayerInRequest();
        when(userInput.getPlayerCreationRequest()).thenReturn(request);
        when(converter.convert(request)).thenReturn(player());

        victim.execute();

        verify(userInput).getPlayerCreationRequest();
        verify(converter).convert(captor.capture());

        CreatePlayerInRequest capturedRequest = captor.getValue();

        assertNotNull(capturedRequest);
        assertEquals("Name", capturedRequest.getName());
        assertEquals("Surname", capturedRequest.getSurname());

        verify(playerService).createPlayer(player());
    }

    private CreatePlayerInRequest createPlayerInRequest() {
        return new CreatePlayerInRequest("Name", "Surname");
    }

    private Player player() {
        return Player.builder()
                .name("Name")
                .surname("Surname")
                .rating(1000)
                .build();
    }
}