package System.PostalManager;
import System.Customer.Customer;
import System.*;
public interface PostalManagerCustomerActions {
    boolean addACustomer(String name, Address address, int id);
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    Customer getCustomerById(int id);
}
