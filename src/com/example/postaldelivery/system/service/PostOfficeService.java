package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.actions.PostOfficeCustomerActions;
import com.example.postaldelivery.system.actions.PostOfficeManagerActions;
import com.example.postaldelivery.system.actions.PostOfficePostManActions;
import com.example.postaldelivery.system.actions.PostOfficePostsActions;
import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.core.PostalManager;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public class PostOfficeService implements PostOfficePostsActions, PostOfficeCustomerActions, PostOfficeManagerActions, PostOfficePostManActions {
    PostOffice postOffice;
    PostOfficePostsService postsService;
    PostOfficeCustomerService customerService;
    PostOfficeManagerService managerService;
    PostOfficePostManService postManService;

    public PostOfficeService(PostOffice postOffice) {
        this.postsService = new PostOfficePostsService(postOffice);
        this.customerService = new PostOfficeCustomerService(postOffice);
        this.managerService = new PostOfficeManagerService(postOffice);
        this.postManService = new PostOfficePostManService(postOffice);
        this.postOffice = postOffice;
    }

    @Override
    public List<PostCard> getAllPosts(){
        return postsService.getAllPosts();
    }
    @Override
    public String addPost(PostCard post){
        return postsService.addPost(post);
    }
    @Override
    public String getStatusOfADelivery(String pId){
        return postsService.getStatusOfADelivery(pId);
    }
    @Override
    public void setStatusOfADelivery(String pId, String status){
        postsService.setStatusOfADelivery(pId, status);
    }
    @Override
    public void assignManager(PostalManager manager){
        managerService.assignManager(manager);
    }
    @Override
    public PostalManager getManager() {
        return managerService.getManager();
    }
    @Override
    public void assignPostMan(PostMan postMan){
        postManService.assignPostMan(postMan);
    }
    @Override
    public PostMan getPostMan(){
        return postManService.getPostMan();
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair){
        return customerService.getIdOfACustomer(nameAddressPair);
    }
    public void addInCustomersNameAddressPairAndIdMap(NameAddressPair nameAddressPair, int id){
        customerService.addInCustomersNameAddressPairAndIdMap(nameAddressPair, id);
    }
    @Override
    public boolean addCustomer(NameAddressPair customerDetails, int id){
        return customerService.addCustomer(customerDetails, id);
    }
    @Override
    public Customer getCustomerById(int id){
        return customerService.getCustomerById(id);
    }
}
