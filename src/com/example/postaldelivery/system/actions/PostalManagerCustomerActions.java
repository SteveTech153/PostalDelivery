package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.NameAddressPair;

public interface PostalManagerCustomerActions {
    boolean addACustomer(String name, Address address, int id);
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    Customer getCustomerById(int id);
}
