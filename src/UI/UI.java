package UI;

import Util.Authenticator;
import Util.Validator;

import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Validator validator;
    private Authenticator authenticator;
    private AdminUI adminUI;
    private CustomerUI customerUI;
    private PostManUI postmanUI;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.authenticator = new Authenticator();

        this.adminUI = new AdminUI(scanner, validator, authenticator);
        this.customerUI = new CustomerUI(scanner, validator, authenticator);
        this.postmanUI = new PostManUI(scanner, authenticator);
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
