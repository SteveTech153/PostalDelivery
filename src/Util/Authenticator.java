package Util;
import DB.CustomersDB;
import DB.PostOfficesDB;
import System.*;

public class Authenticator {
    public Admin authenticateAdmin(String name, String password) {
        try {
            return new Admin(name, password);
        } catch (IllegalAccessException e) {
            return null;
        }
    }
    public PostMan authenticatePostMan(String city, String password) {
        if(PostMan.passwordMatches(password)){
            return PostOfficesDB.getAPostOfficeOfACity(city).getPostMan();
        }
        return null;
    }
    public Customer authenticateCustomer(String name, String aadharNumber) {
        if( CustomersDB.getCustomerByAadhar(aadharNumber) != null){
            return CustomersDB.getCustomerByAadhar(aadharNumber);
        }
        Customer customer = new Customer(name, aadharNumber);
        CustomersDB.addCustomer(customer);
        return customer;
    }
}
