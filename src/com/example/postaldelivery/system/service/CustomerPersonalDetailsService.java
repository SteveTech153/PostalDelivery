package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.actions.CustomerPersonalDetailsActions;
import com.example.postaldelivery.system.entities.support.Address;

public class CustomerPersonalDetailsService implements CustomerPersonalDetailsActions {
    private final PostalManagerCustomerAssistance postalManagerService;
    public CustomerPersonalDetailsService(PostalManagerCustomerAssistance postalManagerService){
        this.postalManagerService = postalManagerService;
    }
    @Override
    public boolean registerAddress(String name, Address address, int id){
        if(postalManagerService!=null){
            return postalManagerService.addACustomer(name, address, id);
        }
        return false;
    }
}
