package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;
import com.example.postaldelivery.system.actions.PostalManagerCustomerActions;
import com.example.postaldelivery.system.actions.PostalManagerPostsActions;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public class PostalManagerService implements PostalManagerCustomerActions, PostalManagerPostsActions, PostalManagerCustomerAssistance, PostalManagerPostmanAssistance {
    PostalManagerPostsService postalManagerPostsService;
    PostalManagerCustomerService postalManagerCustomerService;
    private String postalManagerCity;
    public PostalManagerService(String city){
        this.postalManagerCustomerService = new PostalManagerCustomerService(city);
        this.postalManagerPostsService = new PostalManagerPostsService(city);
        this.postalManagerCity = city;
    }

    @Override
    public List<PostCard> getAllPosts() {
        return postalManagerPostsService.getAllPosts();
    }

    @Override
    public String doPost(PostCard post) {
        return postalManagerPostsService.doPost(post);
    }

    @Override
    public String checkStatusOfAPost(String pId) {
        return postalManagerPostsService.checkStatusOfAPost(pId);
    }
    @Override
    public List<PostCard> getPostsOfACity(String city) {
        return postalManagerPostsService.getPostsOfACity(city);
    }
    @Override
    public void setStatusOfADelivery(String pId, String status) {
        postalManagerPostsService.setStatusOfADelivery(pId, status);
    }
    @Override
    public boolean addACustomer(String name, Address address, int id) {
        return postalManagerCustomerService.addACustomer(name, address, id);
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair) {
        return postalManagerCustomerService.getIdOfACustomer(nameAddressPair);
    }
    @Override
    public Customer getCustomerById(int id) {
        return postalManagerCustomerService.getCustomerById(id);
    }
}
