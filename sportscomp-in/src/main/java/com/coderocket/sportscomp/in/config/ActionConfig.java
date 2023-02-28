package com.coderocket.sportscomp.in.config;

import com.coderocket.sportscomp.in.action.ExitAction;
import com.coderocket.sportscomp.in.action.MenuAction;
import com.coderocket.sportscomp.in.action.competition.CreateCompetitionAction;
import com.coderocket.sportscomp.in.action.competition.DeleteCompetitionAction;
import com.coderocket.sportscomp.in.action.competition.ReadAllCompetitionsAction;
import com.coderocket.sportscomp.in.action.competition.ReadCompetitionAction;
import com.coderocket.sportscomp.in.action.player.CreatePlayerAction;
import com.coderocket.sportscomp.in.action.player.ReadAllPlayersAction;
import com.coderocket.sportscomp.in.dto.CompetitionContextHolder;
import com.coderocket.sportscomp.in.dto.ThreadLocalCompetitionContextHolder;
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
            ExitAction exitAction
    ) {
        return List.of(
                createCompetitionAction,
                createPlayerAction,
                readAllCompetitionsAction,
                readAllPlayersAction,
                readCompetitionAction,
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
}
