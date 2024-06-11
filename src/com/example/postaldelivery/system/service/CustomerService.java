package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.support.PostBox;
import com.example.postaldelivery.system.entities.support.PostCard;

public class CustomerService {
    private final PostalManagerCustomerAssistance postalManagerService;
    private final CustomerPostsService customerPostsService;
    private final CustomerPersonalDetailsService customerPersonalDetailsService;
    public CustomerService(PostalManagerCustomerAssistance postalManagerService){
        this.postalManagerService = postalManagerService;
        this.customerPostsService = new CustomerPostsService(postalManagerService);
        this.customerPersonalDetailsService = new CustomerPersonalDetailsService(postalManagerService);
    }
    public void checkAllPosts(PostBox postBox) {
        customerPostsService.checkAllPosts(postBox);
    }

    public String doPost(PostCard postCard) {
        return customerPostsService.doPost(postCard);
    }

    public String checkStatusOfAPost(String pId) {
        return customerPostsService.checkStatusOfAPost(pId);
    }

    public boolean registerAddress(String name, Address address, int id) {
        return customerPersonalDetailsService.registerAddress(name, address, id);
    }

}
