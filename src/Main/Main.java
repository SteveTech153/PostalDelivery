package Main;
import DB.CustomersDB;
import System.*;
import System.Admin.Admin;
import System.Customer.Customer;
import System.Address;
import System.PostMan.PostMan;
import Util.Authenticator;
import UI.*;

public class Main {
//    static {
//        Admin admin = null;
//        try {
//            admin = new Authenticator().authenticateAndGetAdmin("admin1", "Admin@123");
//        }catch (Exception e){}
//        if(admin != null){
//            admin.addPostOffice("chennai");
//            admin.addPostOffice("madurai");
//            admin.addPostOffice("trichy");
//            admin.addPostOffice("coimbatore");
//            admin.addPostOffice("salem");
////            admin.addPostOffice("Tirunelveli");
////            admin.addPostOffice("Tiruppur");
////            admin.addPostOffice("Vellore");
////            admin.addPostOffice("Tiruvannamalai");
////            admin.addPostOffice("Thanjavur");
////            admin.addPostOffice("Dindigul");
////            admin.addPostOffice("Kanchipuram");
////            admin.addPostOffice("Nagercoil");
////            admin.addPostOffice("Hosur");
////            admin.addPostOffice("Karur");
////            admin.addPostOffice("Namakkal");
////            admin.addPostOffice("Erode");
////            admin.addPostOffice("Cuddalore");
////            admin.addPostOffice("Kumbakonam");
////            admin.addPostOffice("Neyveli");
////            admin.addPostOffice("Karaikudi");
////            admin.addPostOffice("Pollachi");
////            admin.addPostOffice("Rajapalayam");
////            admin.addPostOffice("Sivakasi");
////            admin.addPostOffice("Pudukkottai");
////            admin.addPostOffice("Ooty");
////            admin.addPostOffice("Tiruchendur");
////            admin.addPostOffice("Tiruvallur");
////            admin.addPostOffice("Tirupathur");
////            admin.addPostOffice("Tiruppur");
////            admin.addPostOffice("Tiruvannamalai");
////            admin.addPostOffice("Tiruvarur");
////            admin.addPostOffice("Tuticorin");
////            admin.addPostOffice("Udhagamandalam");
////            admin.addPostOffice("Vaniyambadi");
////            admin.addPostOffice("Villupuram");
////            admin.addPostOffice("Virudhunagar");
////            admin.addPostOffice("Kovilpatti");
////            admin.addPostOffice("Nagapattinam");
////            admin.addPostOffice("Ramanathapuram");
////            admin.addPostOffice("Sankarankovil");
////            admin.addPostOffice("Sivaganga");
////            admin.addPostOffice("Tindivanam");
////            admin.addPostOffice("Tiruchengode");
////            admin.addPostOffice("Tirupathur");
////            admin.addPostOffice("Tiruttani");
////            admin.addPostOffice("Udumalaipettai");
////            admin.addPostOffice("Arakkonam");
////            admin.addPostOffice("Aruppukkottai");
////            admin.addPostOffice("Chidambaram");
////            admin.addPostOffice("Dharmapuri");
////            admin.addPostOffice("Gobichettipalayam");
////            admin.addPostOffice("Kadayanallur");
////            admin.addPostOffice("Kambam");
////            admin.addPostOffice("Karaikal");
////            admin.addPostOffice("Karur");
////            admin.addPostOffice("Nellai");
////            admin.addPostOffice("Pattukkottai");
////            admin.addPostOffice("Perambalur");
//        }
//        Customer steve = new Authenticator().registerCustomer("steve", "123456789123", "chennai");
//        steve.registerAddress("steve", new Address("steve", "guduvancheri", "chennai", "600001"), steve.getId());
//        Customer gowtham = new Authenticator().registerCustomer("gowtham", "123456789124", "madurai");
//        gowtham.registerAddress("gowtham", new Address("gowtham", "kk nagar", "madurai", "630003"), gowtham.getId());
//
//    }
    public static void main(String[] args) {
        UI ui = new UI();
        ui.display();
    }
}