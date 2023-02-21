package com.coderocket.sportscomp.ui.action;

import org.springframework.stereotype.Component;

@Component
public class ExitAction implements MenuAction {

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
