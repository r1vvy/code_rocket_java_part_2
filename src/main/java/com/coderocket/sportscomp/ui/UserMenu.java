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
        MenuAction menuActionChoiceFromUser;

        while(true) {
            System.out.println("Hello! Please choose an action: ");
            printAllActions(userReadMenuActions);

            try {
                int userActionChoice = userInput.getActionChoice();
                validateUserActionChoice(userActionChoice, 0);

                menuActionChoiceFromUser = userReadMenuActions.get(userActionChoice);
                menuActionChoiceFromUser.execute();
            } catch(IllegalArgumentException | InputMismatchException e) {
                System.err.println("Invalid menu action choice.");
                System.err.println("Please try again!");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void executeMenuAction(int index) {
        userReadMenuActions.get(index).execute();
    }

    private void printAllActions(List<MenuAction> actions) {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).getName());
        }
    }

    private void validateUserActionChoice(int choice, int startIndex) {
        if(choice < 0 || choice >= this.userReadMenuActions.size()) {
            throw new IllegalArgumentException("Action choice invalid");
        }
    }
}
