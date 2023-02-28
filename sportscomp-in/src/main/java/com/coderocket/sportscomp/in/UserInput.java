package com.coderocket.sportscomp.in;

import com.coderocket.sportscomp.in.dto.*;
import com.coderocket.sportscomp.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInput {

    // TODO: separate this;
    @Autowired
    @Qualifier("competitionContextHolder")
    private CompetitionContextHolder competitionContextHolder;

    @Autowired
    @Qualifier("playerContextHolder")
    private PlayerContextHolder playerContextHolder;

    public int getActionChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public CreatePlayerInRequest getCreatePlayerRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Surname: ");
        String surname = scanner.nextLine();

        return new CreatePlayerInRequest(name, surname);
    }

    public ReadPlayerByIdRequest getPlayerReadRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID: ");
        Integer id = Integer.valueOf(scanner.nextInt());

        return new ReadPlayerByIdRequest(id);
    }

    public CreateCompetitionInRequest getCreateCompetitionRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Max capacity: ");
        Integer capacity = Integer.valueOf(scanner.nextLine());

        System.out.println("Registration Opening date: ");
        String registrationOpen = scanner.nextLine();

        System.out.println("Registration Closing date: ");
        String registrationClose = scanner.nextLine();

        System.out.println("Starting date: ");
        String startDate = scanner.nextLine();

        System.out.println("Ending date: ");
        String endDate = scanner.nextLine();

        return new CreateCompetitionInRequest(
                title,
                capacity,
                DateTimeUtils.formatStringAsLocalDate(registrationOpen),
                DateTimeUtils.formatStringAsLocalDate(registrationClose),
                DateTimeUtils.formatStringAsLocalDate(startDate),
                DateTimeUtils.formatStringAsLocalDate(endDate)
        );
    }

    public ReadCompetitionByIdRequest getReadCompetitionByIdRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID: ");
        Integer id = Integer.valueOf(scanner.nextInt());

        return new ReadCompetitionByIdRequest(id);
    }

    public DeleteCompetitionRequest getDeleteCompetitionRequest() {
        String userChoice = getConfirmationFromUser();

        if(userChoice.equalsIgnoreCase("Y")) {
            DeleteCompetitionRequest request = new DeleteCompetitionRequest();
            request.setCompetition(competitionContextHolder.getChosenCompetition());
            return request;
        } else if(userChoice.equalsIgnoreCase("N")){
            // TODO
            return null;
        } else {
            // TOOD this.getDeleteCompetitionRequest();
            throw new IllegalArgumentException("Invalid input. Please enter Y or N.");
        }
    }

    private static String getConfirmationFromUser() {
        System.out.println("Are you sure you wish to continue? [Y/N]");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        return userChoice;
    }

    public DeletePlayerRequest getDeletePlayerRequest() {
        System.out.println("Are you sure you wish to continue? [Y/N]");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        if(userChoice.equalsIgnoreCase("Y")) {
            DeletePlayerRequest request = new DeletePlayerRequest();
            request.setPlayer(playerContextHolder.getChosenPlayer());

            return request;

        } else if(userChoice.equalsIgnoreCase("N")){
            // TODO
            return null;
        } else {
            // TOOD this.getDeleteCompetitionRequest();
            throw new IllegalArgumentException("Invalid input. Please enter Y or N.");
        }
    }
}
