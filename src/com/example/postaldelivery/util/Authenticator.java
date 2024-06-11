package com.example.postaldelivery.util;
import com.example.postaldelivery.db.CustomersDB;
import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.entities.core.Admin;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.system.service.CustomerService;

public class Authenticator {
    public Admin authenticateAndGetAdmin(String name, String password) {
        try {
            return new Admin(name, password);
        }catch (Exception e){
            System.out.println("Your password is incorrect !");
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
        PostalManagerCustomerAssistance managerService = PostOfficesDB.getAPostOfficeOfACity(city).getManager();
        Customer customer = new Customer(name, aadharNumber, new CustomerService(managerService));
        CustomersDB.addCustomer(customer);
        return customer;
    }
}
