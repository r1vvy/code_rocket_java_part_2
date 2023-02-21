package com.coderocket.sportscomp.ui;

import com.coderocket.sportscomp.dto.CreateCompetitionInRequest;
import com.coderocket.sportscomp.dto.CreatePlayerInRequest;
import com.coderocket.sportscomp.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInput {

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
}
