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

    public int getActionChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public CreatePlayerInRequest getPlayerCreationRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Surname: ");
        String surname = scanner.nextLine();

        return new CreatePlayerInRequest(name, surname);
    }

    public CreateCompetitionInRequest getCompetitionCreationRequest() {
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
        System.out.println("Are you sure you wish to continue? [Y/N]");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        if(userChoice.equalsIgnoreCase("Y")) {
            DeleteCompetitionRequest request = new DeleteCompetitionRequest();

            request.setCompetition(competitionContextHolder.getChosenCompetition());

            return request;
        } else if(userChoice.equalsIgnoreCase("N")){
            // TODO create interface Request Handler that handles wether the request should be cancelled or not.
            // TODO create DeleteCompetitionHandler that handles the request.
            return null;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
