package UI;

import System.PostMan;
import Util.Authenticator;

import java.util.Scanner;

public class PostManUI {
    private Scanner scanner;
    private Authenticator authenticator;

    public PostManUI(Scanner scanner, Authenticator authenticator) {
        this.scanner = scanner;
        this.authenticator = authenticator;
    }

    public void displayPostmanMenu() {
        System.out.println("\n----------Postman Login----------");
        PostMan postMan = null;
        while (postMan == null) {
            System.out.print("Enter city : ");
            String city = scanner.nextLine();
            System.out.print("Enter password : ");
            String password = scanner.nextLine();
            postMan = authenticator.authenticatePostMan(city, password);
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
            System.out.println("0. Logout");
            postManChoice = scanner.nextLine();
            switch (postManChoice) {
                case "1":
                    postMan.doDeliveries();
                    System.out.println("Deliveries done successfully!\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
