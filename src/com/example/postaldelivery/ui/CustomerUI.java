package com.example.postaldelivery.ui;

import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.PostCard;
import com.example.postaldelivery.util.Authenticator;
import com.example.postaldelivery.util.Validator;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {
    private Scanner scanner;
    private Validator validator;
    private Authenticator authenticator;
    private Customer customer;
    public CustomerUI() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.authenticator = new Authenticator();
        this.customer = null;
    }

    public void displayCustomerMenu() {
        System.out.println("\n----------Customer Menu----------");
        String choice = "";
        while(!choice.equals("0")){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    login();
                    String customerChoice = "";
                    while (!customerChoice.equals("0")) {
                        System.out.println("1. Send a Post Card");
                        System.out.println("2. Track a Post Card");
                        System.out.println("3. Register address");
                        System.out.println("4. Check all posts");
                        System.out.println("0. Logout");
                        customerChoice = scanner.nextLine();
                        switch (customerChoice) {
                            case "1":
                                sendPostCard();
                                break;
                            case "2":
                                trackPostCard();
                                break;
                            case "3":
                                registerAddress();
                                break;
                            case "4":
                                customer.checkAllPosts(customer.getPostBox());
                                System.out.println();
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Invalid choice!\n");
                        }
                    }
                    break;
                case "2":
                    register();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }

    private void sendPostCard() {
        System.out.println("Enter sender pincode : ");
        String senderPincode = scanner.nextLine();
        while (!validator.validatePincode(senderPincode)) {
            System.out.println("Invalid pincode! (pincode should be 6 digits long and numbers only)");
            System.out.print("Enter sender pincode : ");
            senderPincode = scanner.nextLine();
        }
        System.out.println("Enter sender city : ");
        String senderCity = scanner.nextLine();
        while (!validator.validateCity(senderCity)) {
            System.out.println("Invalid city! (city should be at least 2 characters long and alphabets only)");
            System.out.print("Enter sender city : ");
            senderCity = scanner.nextLine();
        }
        System.out.println("Enter sender address : ");
        String senderAddress = scanner.nextLine();
        while (!validator.validateAddress(senderAddress)) {
            System.out.println("Invalid address! (address should be at least 3 characters long and alphabets, numbers, comma, and hyphen only)");
            System.out.print("Enter sender address : ");
            senderAddress = scanner.nextLine();
        }
        System.out.println("Enter sender name : ");
        String senderName = scanner.nextLine();
        while (!validator.validateName(senderName)) {
            System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
            System.out.print("Enter sender name : ");
            senderName = scanner.nextLine();
        }
        System.out.println("Enter receiver pincode : ");
        String receiverPincode = scanner.nextLine();
        while (!validator.validatePincode(receiverPincode)) {
            System.out.println("Invalid pincode! (pincode should be 6 digits long and numbers only)");
            System.out.print("Enter receiver pincode : ");
            receiverPincode = scanner.nextLine();
        }
        System.out.println("Enter receiver city : ");
        String receiverCity = scanner.nextLine();
        while (!validator.validateCity(receiverCity)) {
            System.out.println("Invalid city! (city should be at least 2 characters long and alphabets only)");
            System.out.print("Enter receiver city : ");
            receiverCity = scanner.nextLine();
        }
        System.out.println("Enter receiver address : ");
        String receiverAddress = scanner.nextLine();
        while (!validator.validateAddress(receiverAddress)) {
            System.out.println("Invalid address! (address should be at least 10 characters long and alphabets, numbers, comma, and hyphen only)");
            System.out.print("Enter receiver address : ");
            receiverAddress = scanner.nextLine();
        }
        System.out.println("Enter receiver name : ");
        String receiverName = scanner.nextLine();
        while (!validator.validateName(receiverName)) {
            System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
            System.out.print("Enter receiver name : ");
            receiverName = scanner.nextLine();
        }
        System.out.println("Enter message : ");
        String message = scanner.nextLine();
        System.out.println(customer.doPost(new PostCard(new Address(senderName, senderAddress, senderCity, senderPincode), new Address(receiverName, receiverAddress, receiverCity, receiverPincode), message)));
        System.out.println();
    }

    private void trackPostCard() {
        System.out.println("Enter Post Card Id : ");
        String pId = scanner.nextLine();
        System.out.println(customer.checkStatusOfAPost(pId) + "\n");
    }

    private void registerAddress() {
        System.out.println("Enter your pincode : ");
        String pincode = scanner.nextLine();
        while (!validator.validatePincode(pincode)) {
            System.out.println("Invalid pincode! (pincode should be 6 digits long and numbers only)");
            System.out.print("Enter your pincode : ");
            pincode = scanner.nextLine();
        }
        System.out.println("Select your city : ");
        List<String> cities = PostOfficesDB.getCities();
        for(int i=0; i<cities.size(); i++){
            System.out.println((i+1)+". "+cities.get(i));
        }
        String cityChoice = scanner.nextLine();
        while(Integer.parseInt(cityChoice)<1 || Integer.parseInt(cityChoice)>cities.size()){
            System.out.println("Invalid choice! (choose a number from 1 to "+cities.size()+")");
            System.out.print("Select your city : ");
            cityChoice = scanner.nextLine();
        }
        System.out.println("Enter your address : ");
        String address = scanner.nextLine();
        while (!validator.validateAddress(address)) {
            System.out.println("Invalid address! (address should be at least 10 characters long and alphabets, numbers, comma, and hyphen only)");
            System.out.print("Enter your address : ");
            address = scanner.nextLine();
        }
        if (customer.registerAddress(customer.getName(), new Address(customer.getName(), address.toLowerCase(), cities.get(Integer.parseInt(cityChoice) - 1), pincode), customer.getId())) {
            System.out.println("Address registered successfully!");
        } else {
            System.out.println("Address could not be registered!");
        }
        System.out.println();
    }
    public void login(){
        System.out.println("Please enter your aadhar number : ");
        String aadharNumber = scanner.nextLine();
        while (!validator.validateAadharNumber(aadharNumber)) {
            System.out.println("Invalid aadhar number! (aadhar should be 12 digits)");
            System.out.print("Please enter a valid aadhar number : ");
            aadharNumber = scanner.nextLine();
        }
        customer = authenticator.authenticateAndGetCustomer( aadharNumber);
        if(customer==null){
            System.out.println("Invalid Aadhar!");
            return;
        }
    }
    public void register(){
        List<String> cities = PostOfficesDB.getCities();
        if(cities.size()==0){
            System.out.println("Cannot register! No cities available!");
            return;
        }
        System.out.println("Please enter your name : ");
        String name = scanner.nextLine();
        while (!validator.validateName(name)) {
            System.out.println("Invalid name! (name should be at least 3 characters long and alphabets only)");
            System.out.print("Please enter a valid name : ");
            name = scanner.nextLine();
        }
        System.out.println("Please enter your aadhar number : ");
        String aadharNumber = scanner.nextLine();
        while (!validator.validateAadharNumber(aadharNumber)) {
            System.out.println("Invalid aadhar number! (aadhar should be 12 digits)");
            System.out.print("Please enter a valid aadhar number : ");
            aadharNumber = scanner.nextLine();
        }
        System.out.println("Please select the city : ");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }
        String cityChoice = scanner.nextLine();
        while (Integer.parseInt(cityChoice) < 1 || Integer.parseInt(cityChoice) > cities.size()) {
            System.out.println("Invalid choice! (choose a number from 1 to " + cities.size() + ")");
            System.out.print("Please select the city : ");
            cityChoice = scanner.nextLine();
        }
        customer = authenticator.registerCustomer(name, aadharNumber, cities.get(Integer.parseInt(cityChoice) - 1));
        if (customer == null) {
            System.out.println("Authentication failed!");
            return;
        }
    }
}
