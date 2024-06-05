package System.PostOffice;
import System.Customer.Customer;
import System.*;

public interface PostOfficeCustomerActions {
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    boolean addCustomer(NameAddressPair customerDetails, int id);
    Customer getCustomerById(int id);
}