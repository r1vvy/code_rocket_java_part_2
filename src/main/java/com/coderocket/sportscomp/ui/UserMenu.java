package com.coderocket.sportscomp.ui;

import com.coderocket.sportscomp.ui.action.MenuAction;
import com.coderocket.sportscomp.ui.action.MenuActionWithSubActions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMenu {

    private final UserInput userInput;
    @Autowired
    @Qualifier(value = "userReadMenuActions")
    private final List<MenuAction> userReadMenuActions;

    public void startMenu() {

        while(true) {
            System.out.println("Hello! Please choose an action: ");
            printAllActions(userReadMenuActions);

            try {
                MenuAction action = getMenuActionChoiceFromUser(userReadMenuActions);
                action.execute();

                if(isMenuActionWithSubActions(action)) {
                    List<MenuAction> subActions = getSubActionsFromMenuAction((MenuActionWithSubActions) action);

                    printAllActions(subActions);

                    MenuAction subAction = getMenuActionChoiceFromUser(subActions);
                    subAction.execute();
                }
            } catch(IllegalArgumentException | InputMismatchException e) {
                System.err.println("Invalid menu action choice.");
                System.err.println("Please try again!");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private MenuAction getMenuActionChoiceFromUser(List<MenuAction> actions) {
        int userActionChoice = getUserActionChoice();
        MenuAction action = actions.get(userActionChoice);
        return action;
    }

    private List<MenuAction> getSubActionsFromMenuAction(MenuActionWithSubActions action) {
        List<MenuAction> subActions = action.getSubActions();
        return subActions;
    }

    private int getUserActionChoice() {
        int userActionChoice = userInput.getActionChoice();
        return userActionChoice;
    }

    private boolean isMenuActionWithSubActions(MenuAction action) {
        return action instanceof MenuActionWithSubActions ? true : false;
    }
    private void printAllActions(List<MenuAction> actions) {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).getName());
        }
    }

}
