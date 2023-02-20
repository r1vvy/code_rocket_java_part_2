package com.coderocket.sportscomp.ui;

import com.coderocket.sportscomp.ui.action.MenuAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMenu {
    private final UserInput userInput;
    private final List<MenuAction> userReadMenuActions;

    public void startMenu() {
        int menuActionChoiceFromUser;

        while(true) {
            System.out.println("Hello! Please choose an action: ");
            printAllActions();

            try {
                menuActionChoiceFromUser = userInput.getActionChoice();
                validateUserActionChoice(menuActionChoiceFromUser, 0);
                executeMenuAction(menuActionChoiceFromUser);
            } catch(IllegalArgumentException | InputMismatchException e) {
                System.err.println("Invalid menu action choice.");
                System.err.println("Please try again!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void executeMenuAction(int index) {
        userReadMenuActions.get(index).execute();
    }

    private void printAllActions() {
        for (int i = 0; i < userReadMenuActions.size(); i++) {
            System.out.println(i + ". " + userReadMenuActions.get(i).getName());
        }
    }

    private void validateUserActionChoice(int choice, int startIndex) {
        if(choice < 0 || choice >= this.userReadMenuActions.size()) {
            throw new IllegalArgumentException("Action choice invalid");
        }
    }
}
