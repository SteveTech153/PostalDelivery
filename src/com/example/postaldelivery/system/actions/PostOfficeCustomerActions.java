package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.NameAddressPair;

public interface PostOfficeCustomerActions {
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    boolean addCustomer(NameAddressPair customerDetails, int id);
    Customer getCustomerById(int id);
}