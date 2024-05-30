package System;

public interface PostOfficeCustomerActions {
    public int getIdOfACustomer(NameAddressPair nameAddressPair);
    public boolean addCustomer(NameAddressPair customerDetails, int id);
    public Customer getCustomerById(int id);
}
