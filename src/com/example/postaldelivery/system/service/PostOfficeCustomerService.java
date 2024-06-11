package com.example.postaldelivery.system.service;

import com.example.postaldelivery.db.CustomersDB;
import com.example.postaldelivery.system.actions.PostOfficeCustomerActions;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.support.NameAddressPair;

public class PostOfficeCustomerService implements PostOfficeCustomerActions {
    private PostOffice postOffice;
    public PostOfficeCustomerService(PostOffice postOffice){
        this.postOffice = postOffice;
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair){
        return postOffice.getCustomersNameAddressPairAndIdMap().get(nameAddressPair);
    }
    public void addInCustomersNameAddressPairAndIdMap(NameAddressPair nameAddressPair, int id){
        postOffice.getCustomersNameAddressPairAndIdMap().put(nameAddressPair, id);
    }
    @Override
    public boolean addCustomer(NameAddressPair customerDetails, int id){
        if(!this.postOffice.getCustomersDetails().contains(customerDetails)){
            this.postOffice.getCustomersDetails().add(customerDetails);
            addInCustomersNameAddressPairAndIdMap(customerDetails, id);
            CustomersDB.getCustomerById(id).setAddress(customerDetails.getAddress());
            return true;
        }
        return false;
    }
    @Override
    public Customer getCustomerById(int id){
        return CustomersDB.getCustomerById(id);
    }
}
