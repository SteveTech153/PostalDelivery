package Util;
import DB.CustomersDB;
import DB.PostOfficesDB;
import System.Admin.Admin;
import System.Customer.Customer;
import System.PostMan.PostMan;

public class Authenticator {
    public Admin authenticateAndGetAdmin(String name, String password) {
        if(Admin.passwordMatches(password)){
            try {
                return new Admin(name, password);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    public PostMan authenticateAndGetPostMan(String city, String password) {
        if(PostMan.passwordMatches(password)){
            return PostOfficesDB.getAPostOfficeOfACity(city).getPostMan();
        }
        return null;
    }
    public Customer authenticateAndGetCustomer(String aadharNumber) {
        if( CustomersDB.getCustomerByAadhar(aadharNumber) != null){
            return CustomersDB.getCustomerByAadhar(aadharNumber);
        }
        return null;
    }
    public Customer registerCustomer(String name, String aadharNumber, String city) {
        if( CustomersDB.getCustomerByAadhar(aadharNumber) != null){
            return CustomersDB.getCustomerByAadhar(aadharNumber);
        }
        Customer customer = new Customer(name, aadharNumber, PostOfficesDB.getManagerOfACity(city));
        CustomersDB.addCustomer(customer);
        return customer;
    }
}
