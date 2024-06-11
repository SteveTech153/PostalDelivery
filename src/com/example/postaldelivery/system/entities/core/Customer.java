package com.example.postaldelivery.system.entities.core;

import com.example.postaldelivery.system.actions.CustomerPersonalDetailsActions;
import com.example.postaldelivery.system.actions.CustomerPostsActions;
import com.example.postaldelivery.system.entities.support.Address;
import com.example.postaldelivery.system.entities.support.PostBox;
import com.example.postaldelivery.system.entities.support.PostCard;
import com.example.postaldelivery.system.service.CustomerService;

public class Customer extends User implements CustomerPostsActions, CustomerPersonalDetailsActions{
    private static int indexIncrement = 0;
    private final int id;
    private Address address;
    private final String aadharNumber;
    private final PostBox postBox;
    private final CustomerService service;
    public Customer(String name, String aadharNumber, CustomerService customerService){
        super(name);
        this.id = ++indexIncrement;
        this.postBox = new PostBox();
        this.aadharNumber = aadharNumber;
        this.service = customerService;
    }
    public String getAadharNumber(){
        return aadharNumber;
    }
    public int getId(){
        return id;
    }
    public PostBox getPostBox(){
        return postBox;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    public String doPost(PostCard postCard) {
        return service.doPost(postCard);
    }

    public String checkStatusOfAPost(String pId) {
        return service.checkStatusOfAPost(pId);
    }

    public void checkAllPosts(PostBox postBox) {
        service.checkAllPosts(postBox);
    }

    public boolean registerAddress(String name, Address address, int id) {
        return service.registerAddress(name, address, id);
    }
}