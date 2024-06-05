package System.PostalManager;

import System.Customer.Customer;

import java.util.List;
import System.*;

public interface PostalManagerPostmanService {
    List<PostCard> getAllPosts();
    void setStatusOfADelivery(String pId, String status);
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    Customer getCustomerById(int id);
}
