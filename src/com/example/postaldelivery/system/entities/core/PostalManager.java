package com.example.postaldelivery.system.entities.core;
import com.example.postaldelivery.system.actions.PostalManagerCustomerActions;
import com.example.postaldelivery.system.actions.PostalManagerPostsActions;
import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;
import com.example.postaldelivery.system.service.PasswordService;
import com.example.postaldelivery.system.service.PostalManagerService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PostalManager extends User implements PostalManagerCustomerAssistance, PostalManagerPostmanAssistance, PostalManagerCustomerActions, PostalManagerPostsActions {
    private static String postalManagerPassword = "LfI+54Rw0CjvlghNtVkfwwbMpZPCMldkiFIyRwiyAXU=";
    private String city;
    private final PasswordService passwordService;
    private final PostalManagerService service;
    public PostalManager(String name, String password, String city) throws IllegalAccessException, NoSuchAlgorithmException {
        super(name);
        this.passwordService = new PasswordService();
        if (!passwordService.checkPassword(password, postalManagerPassword)) {
            throw new IllegalAccessException("Password is wrong !");
        }
        this.city = city;
        this.service = new PostalManagerService(city);
    }

    public List<PostCard> getAllPosts() {
        return service.getAllPosts();
    }

    public String doPost(PostCard post) {
        return service.doPost(post);
    }

    public String checkStatusOfAPost(String pId) {
        return service.checkStatusOfAPost(pId);
    }

    public List<PostCard> getPostsOfACity(String city) {
        return service.getPostsOfACity(city);
    }

    public boolean addACustomer(String name, Address address, int id) {
        return service.addACustomer(name, address, id);
    }

    public int getIdOfACustomer(NameAddressPair nameAddressPair) {
        return service.getIdOfACustomer(nameAddressPair);
    }

    public Customer getCustomerById(int id) {
        return service.getCustomerById(id);
    }

    public void setStatusOfADelivery(String pId, String status) {
        service.setStatusOfADelivery(pId, status);
    }
}