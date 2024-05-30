package Main;
import java.util.Scanner;

import DB.CustomersDB;
import DB.PostOfficesDB;
import System.*;
import Util.Authenticator;
import Util.Validator;

public class Main {
    static {
        Admin admin = null;
        try {
            admin = new Authenticator().authenticateAdmin("admin1", "Admin@123");
        }catch (Exception e){}
        if(admin != null){
            admin.addPostOffice("chennai");
            admin.addPostOffice("madurai");
            admin.addPostOffice("trichy");
            admin.addPostOffice("coimbatore");
            admin.addPostOffice("salem");
//            admin.addPostOffice("Tirunelveli");
//            admin.addPostOffice("Tiruppur");
//            admin.addPostOffice("Vellore");
//            admin.addPostOffice("Tiruvannamalai");
//            admin.addPostOffice("Thanjavur");
//            admin.addPostOffice("Dindigul");
//            admin.addPostOffice("Kanchipuram");
//            admin.addPostOffice("Nagercoil");
//            admin.addPostOffice("Hosur");
//            admin.addPostOffice("Karur");
//            admin.addPostOffice("Namakkal");
//            admin.addPostOffice("Erode");
//            admin.addPostOffice("Cuddalore");
//            admin.addPostOffice("Kumbakonam");
//            admin.addPostOffice("Neyveli");
//            admin.addPostOffice("Karaikudi");
//            admin.addPostOffice("Pollachi");
//            admin.addPostOffice("Rajapalayam");
//            admin.addPostOffice("Sivakasi");
//            admin.addPostOffice("Pudukkottai");
//            admin.addPostOffice("Ooty");
//            admin.addPostOffice("Tiruchendur");
//            admin.addPostOffice("Tiruvallur");
//            admin.addPostOffice("Tirupathur");
//            admin.addPostOffice("Tiruppur");
//            admin.addPostOffice("Tiruvannamalai");
//            admin.addPostOffice("Tiruvarur");
//            admin.addPostOffice("Tuticorin");
//            admin.addPostOffice("Udhagamandalam");
//            admin.addPostOffice("Vaniyambadi");
//            admin.addPostOffice("Villupuram");
//            admin.addPostOffice("Virudhunagar");
//            admin.addPostOffice("Kovilpatti");
//            admin.addPostOffice("Nagapattinam");
//            admin.addPostOffice("Ramanathapuram");
//            admin.addPostOffice("Sankarankovil");
//            admin.addPostOffice("Sivaganga");
//            admin.addPostOffice("Tindivanam");
//            admin.addPostOffice("Tiruchengode");
//            admin.addPostOffice("Tirupathur");
//            admin.addPostOffice("Tiruttani");
//            admin.addPostOffice("Udumalaipettai");
//            admin.addPostOffice("Arakkonam");
//            admin.addPostOffice("Aruppukkottai");
//            admin.addPostOffice("Chidambaram");
//            admin.addPostOffice("Dharmapuri");
//            admin.addPostOffice("Gobichettipalayam");
//            admin.addPostOffice("Kadayanallur");
//            admin.addPostOffice("Kambam");
//            admin.addPostOffice("Karaikal");
//            admin.addPostOffice("Karur");
//            admin.addPostOffice("Nellai");
//            admin.addPostOffice("Pattukkottai");
//            admin.addPostOffice("Perambalur");
        }
        Customer steve = new Authenticator().authenticateCustomer("steve", "123456789123");
        steve.registerAddress("steve", new Address("steve", "guduvancheri", "chennai", "600001"), steve.getId());
        Customer gowtham = new Authenticator().authenticateCustomer("gowtham", "123456789124");
        gowtham.registerAddress("gowtham", new Address("gowtham", "kk nagar", "madurai", "630003"), gowtham.getId());


//        System.out.println(steve.doPost(new PostCard(new Address("steve", "guduvancheri", "chennai", "600001"), new Address("gowtham", "homee", "madurai", "630003"), "Hi gowtham !")));
//        System.out.println(steve.checkStatusOfAPost("0011"));
        //System.out.println(CustomersDB.getCustomerByAadhar("123456789123").getName());
//        PostMan maduraiPostman = new Authenticator().authenticatePostMan("madurai", "Postman@123");
//        System.out.println(maduraiPostman.getName());
//
//        maduraiPostman.doDeliveries();
//
//        System.out.println(gowtham.getPostBox().getAllPosts());
    }

    public static void main(String[] args) {
        System.out.println("_____________________________Welcome to Post Office System_____________________________");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while(!choice.equals("0")){
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Postman");
            System.out.println("3. Customer Menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("\n----------Admin Login----------");
                    Admin admin = null;
                    while(admin == null){
                        System.out.print("Enter name : ");
                        String name = scanner.nextLine();
                        System.out.print("Enter password : ");
                        String password = scanner.nextLine();
                        admin = new Authenticator().authenticateAdmin(name, password);
                        if(admin == null){
                            System.out.println("Invalid city or password");
                            System.out.println("Do you want to try again? (y/n)");
                            if(!scanner.nextLine().equals("y")){
                                break;
                            }
                        }
                    }
                    if(admin == null){
                        break;
                    }
                    System.out.println("Login successful !\n");
                    String adminChoice = "";
                    while(!adminChoice.equals("0")){
                        System.out.println("1. Add Post Office");
                        System.out.println("2. remove Post Office");
                        System.out.println("0. Logout");
                        adminChoice = scanner.nextLine();
                        switch (adminChoice){
                            case "1":
                                System.out.print("Enter city name : ");
                                String city = scanner.nextLine();
                                if(admin.addPostOffice(city)){
                                    System.out.println("Post Office added successfully !");
                                }else{
                                    System.out.println("Post Office could not be added ! City Could be already present !");
                                }
                                System.out.println();
                                break;
                            case "2":

                                System.out.print("Enter city name : ");
                                String cityToRemove = scanner.nextLine();
                                if(admin.removePostOffice(cityToRemove)){
                                    System.out.println("Post Office removed successfully !");
                                }else{
                                    System.out.println("Post Office could not be removed ! City Could be not present !");
                                }
                                System.out.println();
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Invalid choice !\n");
                        }
                    }
                    System.out.println("");
                    break;
                case "2":
                    System.out.println("\n----------Postman Login----------");
                    PostMan postMan = null;
                    while(postMan == null){
                        System.out.print("Enter city : ");
                        String city = scanner.nextLine();
                        System.out.print("Enter password : ");
                        String password = scanner.nextLine();
                        postMan = new Authenticator().authenticatePostMan(city, password);
                        if(postMan == null){
                            System.out.println("Invalid city or password");
                            System.out.println("Do you want to try again? (y/n)");
                            if(!scanner.nextLine().equals("y")){
                                break;
                            }
                        }
                    }
                    if(postMan == null){
                        break;
                    }
                    System.out.println("Login successful !\n");
                    String postManChoice = "";
                    while(!postManChoice.equals("0")){
                        System.out.println("1. Do Deliveries");
                        System.out.println("0. Logout");
                        postManChoice = scanner.nextLine();
                        switch (postManChoice){
                            case "1":
                                postMan.doDeliveries();
                                System.out.println("Deliveries done successfully !\n");
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Invalid choice !\n");
                        }
                    }
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("\n----------Customer Menu----------");
                    System.out.println("Please enter your name : ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your aadhar number : ");
                    String aadharNumber = scanner.nextLine();
                    Validator validator = new Validator();
                    while(!validator.validateAadharNumber(aadharNumber)){
                        System.out.println("Invalid aadhar number (aadhar should be 12 digits)! Please enter a valid aadhar number : ");
                        aadharNumber = scanner.nextLine();
                    }
                    Customer customer = new Authenticator().authenticateCustomer(name, aadharNumber);
                    String customerChoice = "";
                    while(!customerChoice.equals("0")){
                        System.out.println("1. Send a Post Card");
                        System.out.println("2. Track a Post Card");
                        System.out.println("3. Register address");
                        System.out.println("4. Check all posts");
                        System.out.println("0. Logout");
                        customerChoice = scanner.nextLine();
                        switch (customerChoice){
                            case "1":
                                System.out.println("Enter sender pincode : ");
                                String senderPincode = scanner.nextLine();
                                System.out.println("Enter sender city : ");
                                String senderCity = scanner.nextLine();
                                System.out.println("Enter sender address : ");
                                String senderAddress = scanner.nextLine();
                                System.out.println("Enter sender name : ");
                                String senderName = scanner.nextLine();
                                System.out.println("Enter receiver pincode : ");
                                String receiverPincode = scanner.nextLine();
                                System.out.println("Enter receiver city : ");
                                String receiverCity = scanner.nextLine();
                                System.out.println("Enter receiver address : ");
                                String receiverAddress = scanner.nextLine();
                                System.out.println("Enter receiver name : ");
                                String receiverName = scanner.nextLine();
                                System.out.println("Enter message : ");
                                String message = scanner.nextLine();
                                System.out.println(customer.doPost(new PostCard(new Address(senderName, senderAddress, senderCity, senderPincode), new Address(receiverName, receiverAddress, receiverCity, receiverPincode), message)));
                                System.out.println();
                                break;
                            case "2":
                                System.out.println("Enter Post Card Id : ");
                                String pId = scanner.nextLine();
                                System.out.println(customer.checkStatusOfAPost(pId)+"\n");
                                break;
                            case "3":
                                System.out.println("Enter your pincode : ");
                                String pincode = scanner.nextLine();
                                System.out.println("Enter your city : ");
                                String city = scanner.nextLine();
                                System.out.println("Enter your address : ");
                                String address = scanner.nextLine();
                                if(customer.registerAddress(name, new Address(customer.getName(), address.toLowerCase(), city.toLowerCase(), pincode), customer.getId())){
                                    System.out.println("Address registered successfully !");
                                }else{
                                    System.out.println("Address could not be registered.!");
                                }
                                System.out.println();
                                break;
                            case "4":
                                customer.checkAllPosts();
                                System.out.println();
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Invalid choice !\n");

                        }
                    }
                    System.out.println("");
                    break;
            }

        }
        System.out.println("\n_____________________________Thank you for using Post Office System_____________________________\n");
    }
}
