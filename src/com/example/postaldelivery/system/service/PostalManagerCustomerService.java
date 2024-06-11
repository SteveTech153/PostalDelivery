package com.example.postaldelivery.system.service;

import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.actions.PostalManagerCustomerActions;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.NameAddressPair;

public class PostalManagerCustomerService implements PostalManagerCustomerActions {
    private final String postalManagerCity;
    public PostalManagerCustomerService(String city){
        this.postalManagerCity = city;
    }
    @Override
    public boolean addACustomer(String name, Address address, int id) {
        address.setCity(postalManagerCity);
        NameAddressPair customerDetails = new NameAddressPair(name, address);
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(postalManagerCity);
        boolean result = false;
        if (postOffice != null) {
            result = postOffice.addCustomer(customerDetails, id);
        }
        return result;
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(postalManagerCity);
        if (postOffice != null) {
            return postOffice.getIdOfACustomer(nameAddressPair);
        }
        return -1;
    }
    @Override
    public Customer getCustomerById(int id) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(postalManagerCity);
        if (postOffice != null) {
            return postOffice.getCustomerById(id);
        }
        return null;
    }
}
