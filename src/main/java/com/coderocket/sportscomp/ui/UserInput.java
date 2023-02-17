package com.coderocket.sportscomp.ui;

import java.util.Scanner;

public class UserInput {

    public int getActionChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return choice;
    }
}
