package com.example.postaldelivery.ui;

import java.util.Scanner;

public class UI {
    Scanner scanner;
    private AdminUI adminUI;
    private CustomerUI customerUI;
    private PostManUI postmanUI;
    public UI() {
        this.scanner = new Scanner(System.in);
        this.adminUI = new AdminUI();
        this.customerUI = new CustomerUI();
        this.postmanUI = new PostManUI();
    }

    public void display() {
        System.out.println("_____________________________Welcome to Post Office System_____________________________");

        String choice = "";
        while (!choice.equals("0")) {
            System.out.println("\n----------Main Menu----------");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Postman");
            System.out.println("3. Customer Menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    adminUI.displayAdminMenu();
                    break;
                case "2":
                    postmanUI.displayPostmanMenu();
                    break;
                case "3":
                    customerUI.displayCustomerMenu();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }

        System.out.println("\n_____________________________Thank you for using Post Office System_____________________________\n");
    }
}
