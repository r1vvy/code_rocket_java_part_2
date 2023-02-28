package com.coderocket.sportscomp.in.config;

import com.coderocket.sportscomp.in.action.ExitAction;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.action.competition.CreateCompetitionAction;
import com.coderocket.sportscomp.in.action.competition.DeleteCompetitionAction;
import com.coderocket.sportscomp.in.action.competition.ReadAllCompetitionsAction;
import com.coderocket.sportscomp.in.action.competition.ReadCompetitionAction;
import com.coderocket.sportscomp.in.action.player.CreatePlayerAction;
import com.coderocket.sportscomp.in.action.player.DeletePlayerAction;
import com.coderocket.sportscomp.in.action.player.ReadAllPlayersAction;
import com.coderocket.sportscomp.in.action.player.ReadPlayerAction;
import com.coderocket.sportscomp.in.dto.CompetitionContextHolder;
import com.coderocket.sportscomp.in.dto.PlayerContextHolder;
import com.coderocket.sportscomp.in.dto.ThreadLocalCompetitionContextHolder;
import com.coderocket.sportscomp.in.dto.ThreadLocalPlayerContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActionConfig {
    @Bean("userReadMenuActions")
    public List<MenuAction> userReadMenuActions(
            CreateCompetitionAction createCompetitionAction,
            CreatePlayerAction createPlayerAction,
            ReadAllCompetitionsAction readAllCompetitionsAction,
            ReadAllPlayersAction readAllPlayersAction,
            ReadCompetitionAction readCompetitionAction,
            ReadPlayerAction readPlayerAction,
            ExitAction exitAction
    ) {
        return List.of(
                createCompetitionAction,
                createPlayerAction,
                readAllCompetitionsAction,
                readAllPlayersAction,
                readCompetitionAction,
                readPlayerAction,
                exitAction
        );
    }

    @Bean("adminReadWriteActions")
    public List<MenuAction> adminReadWriteActions() { return List.of(); }

    @Bean("competitionSubActions")
    public List<MenuAction> competitionSubActions(
            DeleteCompetitionAction deleteCompetitionAction
        ) {
        return List.of(
                deleteCompetitionAction
        );
    }

    @Bean("competitionContextHolder")
    public CompetitionContextHolder competitionContextHolder() {
        return new ThreadLocalCompetitionContextHolder();
    }


    @Bean("playerSubActions")
    public List<MenuAction> playerSubActions(
            DeletePlayerAction deletePlayerAction
    ) {
        return List.of(
                deletePlayerAction
        );
    }

    @Bean("playerContextHolder")
    public PlayerContextHolder playerContextHolder() {
        return new ThreadLocalPlayerContextHolder();
    }
}
