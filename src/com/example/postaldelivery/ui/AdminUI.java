package com.example.postaldelivery.ui;
import com.example.postaldelivery.system.entities.core.Admin;
import com.example.postaldelivery.util.Authenticator;
import com.example.postaldelivery.util.Validator;

import java.util.List;
import java.util.Scanner;

public class AdminUI {
    private Scanner scanner;
    private Validator validator;
    private Authenticator authenticator;

    public AdminUI() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.authenticator = new Authenticator();
    }

    public void displayAdminMenu() {
        System.out.println("\n----------Admin Login----------");
        Admin admin = null;
        while (admin == null) {
            System.out.print("Enter name : ");
            String name = scanner.nextLine();
            while (!validator.validateName(name)) {
                System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
                System.out.print("Enter name : ");
                name = scanner.nextLine();
            }
            System.out.print("Enter Admin password : ");
            String password = scanner.nextLine();
            admin = authenticator.authenticateAndGetAdmin(name, password);
            if (admin == null) {
                System.out.println("Invalid password");
                System.out.println("Do you want to try again? (y/n)");
                if (!scanner.nextLine().equals("y")) {
                    return;
                }
            }
        }

        System.out.println("Login successful!\n");
        String adminChoice = "";
        while (!adminChoice.equals("0")) {
            System.out.println("1. Add Post Office");
            System.out.println("2. Remove Post Office");
            System.out.println("0. Logout");
            adminChoice = scanner.nextLine();
            switch (adminChoice) {
                case "1":
                    System.out.print("Enter city name : ");
                    String city = scanner.nextLine();
                    while (!validator.validateCity(city)) {
                        System.out.println("Invalid city! (city should be at least 2 characters long and alphabets only)");
                        System.out.print("Enter city name : ");
                        city = scanner.nextLine();
                    }
                    if (admin.addPostOffice(city)) {
                        System.out.println("Post Office added successfully!");
                    } else {
                        System.out.println("Post Office could not be added! City might already be present!");
                    }
                    System.out.println();
                    break;
                case "2":
                    List<String> cities = admin.getAllCities();
                    if (cities.size() == 0) {
                        System.out.println("No cities to remove!");
                        break;
                    }
                    System.out.println("Cities available : ");
                    for (String c : cities) {
                        System.out.println(c);
                    }
                    System.out.print("Enter city name : ");
                    String cityToRemove = scanner.nextLine();
                    if (admin.removePostOffice(cityToRemove)) {
                        System.out.println("Post Office removed successfully!");
                    } else {
                        System.out.println("Post Office could not be removed! City might not be present!");
                    }
                    System.out.println();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
