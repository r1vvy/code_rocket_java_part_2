package com.coderocket.sportscomp.ui;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInput {

    public int getActionChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
