package com.coderocket.sportscomp.ui.action;

import com.coderocket.sportscomp.core.PlayerService;
import com.coderocket.sportscomp.domain.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReadAllPlayersActionTest {
    @Mock
    private PlayerService playerService;

    @Test
    void shouldReturnViewAllPlayersAsActionName() {
        ReadAllPlayersAction victim = new ReadAllPlayersAction(playerService);

        String actual = victim.getName();
        String expected = "View all players";

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallPlayerServiceToReturnAllPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(player());
        players.add(player());

        when(playerService.getAllPlayersAsArrayList()).thenReturn(players);

        ReadAllPlayersAction victim = new ReadAllPlayersAction(playerService);
        victim.execute();

        verify(playerService, times(1)).getAllPlayersAsArrayList();
    }

    private Player player() {
        return Player.builder()
                .name("Test")
                .surname("Test")
                .rating(1000)
                .build();
    }
}