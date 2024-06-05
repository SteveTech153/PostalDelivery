package System.Customer;
import System.Address;
public interface CustomerPersonalDetailsActions {
    boolean registerAddress(String name, Address address, int id);
}
