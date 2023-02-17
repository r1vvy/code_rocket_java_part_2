package com.coderocket.sportscomp.ui;

import com.coderocket.sportscomp.ui.action.MenuAction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserMenu {
    private final UserInput userInput;
    private final List<MenuAction> actions;

    public UserMenu(UserInput userInput, List<MenuAction> actions) {
        this.userInput = userInput;
        this.actions = actions;
    }

    public void startMenu() {
        int menuActionChoiceFromUser;

        while(true) {
            System.out.println("Hello! Please choose an action: ");
            printAllActions();

            try {
                menuActionChoiceFromUser = userInput.getActionChoice();
                // TODO: separate validation class { UserInputValidation }
                validateUserActionChoice(menuActionChoiceFromUser, 0);

                executeMenuAction(menuActionChoiceFromUser);

            } catch(IllegalArgumentException | InputMismatchException e) {
                System.err.println("Invalid menu action choice.");
                System.err.println("Please try again!");
            }
        }
    }

    private void executeMenuAction(int index) {
        actions.get(index).execute();
    }

    private void printAllActions() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).getName());
        }
    }

    private void validateUserActionChoice(int choice, int startIndex) {
        if(choice < 0 || choice >= this.actions.size()) {
            throw new IllegalArgumentException("Action choice invalid");
        }
    }
}
