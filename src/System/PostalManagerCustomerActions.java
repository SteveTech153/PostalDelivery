package System;

public interface PostalManagerCustomerActions {
    public boolean addACustomer(String name, Address address, int id);
    public int getIdOfACustomer(NameAddressPair nameAddressPair);
    public Customer getCustomerById(int id);


}
