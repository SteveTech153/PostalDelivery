package com.example.postaldelivery.system.assistance;

import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.support.PostCard;

public interface PostalManagerCustomerAssistance {
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId) ;
    boolean addACustomer(String name, Address address, int id);
}
