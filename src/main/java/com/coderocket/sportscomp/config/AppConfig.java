package com.coderocket.sportscomp.config;

import com.coderocket.sportscomp.ui.action.MenuAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean("userReadMenuActions")
    public List<MenuAction> userReadMenuActions() {
        return List.of();
    }

    @Bean("adminReadWriteActions")
    public List<MenuAction> adminReadWriteActions() { return List.of(); }
}
