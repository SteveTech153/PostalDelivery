package DB;
import System.Customer.Customer;

import java.util.HashMap;

public class CustomersDB {
    private static HashMap<String, Customer> customersAadharMap = new HashMap<>();
    private static HashMap<Integer, Customer> customerIdMap = new HashMap<>();
    public static boolean addCustomer(Customer customer){
        if(!customersAadharMap.containsKey(customer.getAadharNumber())){
            customersAadharMap.put(customer.getAadharNumber(), customer);
        }else {
            return false;
        }
        if(!customerIdMap.containsKey(customer.getId())){
            customerIdMap.put(customer.getId(), customer);
            return true;
        }else {
            return false;
        }
    }
    public static boolean removeCustomer(String aadharNumber){
        if(customersAadharMap.containsKey(aadharNumber)){
            customersAadharMap.remove(aadharNumber);
            return true;
        }
        return false;
    }
    public static Customer getCustomerByAadhar(String aadharNumber){
        return customersAadharMap.getOrDefault(aadharNumber, null);
    }
    public static Customer getCustomerById(int id){
        return customerIdMap.getOrDefault(id, null);
    }

}
