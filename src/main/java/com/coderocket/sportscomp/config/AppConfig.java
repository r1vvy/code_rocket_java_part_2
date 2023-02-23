package com.coderocket.sportscomp.config;

import com.coderocket.sportscomp.ui.action.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
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
}
