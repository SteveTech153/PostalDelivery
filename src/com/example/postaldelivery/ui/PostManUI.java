package com.example.postaldelivery.ui;

import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.util.Authenticator;

import java.util.Scanner;

public class PostManUI {
    private Scanner scanner;
    private Authenticator authenticator;

    public PostManUI() {
        this.scanner = new Scanner(System.in);
        this.authenticator = new Authenticator();
    }

    public void displayPostmanMenu() {
        System.out.println("\n----------Postman Login----------");
        PostMan postMan = null;
        while (postMan == null) {
            System.out.print("Enter city : ");
            String city = scanner.nextLine();
            System.out.print("Enter password : ");
            String password = scanner.nextLine();
            postMan = authenticator.authenticateAndGetPostMan(city, password);
            if (postMan == null) {
                System.out.println("Invalid city or password");
                System.out.println("Do you want to try again? (y/n)");
                if (!scanner.nextLine().equals("y")) {
                    return;
                }
            }
        }

        System.out.println("Login successful!\n");
        String postManChoice = "";
        while (!postManChoice.equals("0")) {
            System.out.println("1. Do Deliveries");
            System.out.println("2. show all posts to deliver");
            System.out.println("0. Logout");
            postManChoice = scanner.nextLine();
            switch (postManChoice) {
                case "1":
                    System.out.println(postMan.doDeliveries());
                    break;
                case "2":
                    postMan.printAllPosts();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
