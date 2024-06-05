package System.PostalManager;
import System.*;

public interface PostalManagerCustomerService {
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId) ;
    boolean addACustomer(String name, Address address, int id);
}
