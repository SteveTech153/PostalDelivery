package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.assistance.PostalManagerCustomerAssistance;
import com.example.postaldelivery.system.actions.CustomerPostsActions;
import com.example.postaldelivery.system.entities.support.PostBox;
import com.example.postaldelivery.system.entities.support.PostCard;

public class CustomerPostsService implements CustomerPostsActions {
    private final PostalManagerCustomerAssistance postalManagerService;
    public CustomerPostsService(PostalManagerCustomerAssistance postalManagerService){
        this.postalManagerService = postalManagerService;
    }
    @Override
    public String doPost(PostCard post){
        String message = "Your requested city is not available";
        if(postalManagerService!=null) {
            message = postalManagerService.doPost(post);
        }
        return message;
    }
    @Override
    public String checkStatusOfAPost(String pId){
        if(postalManagerService!=null){
            return postalManagerService.checkStatusOfAPost(pId);
        }
        return "Post office of your requested city is not available!";
    }
    @Override
    public void checkAllPosts(PostBox postBox){
        for(PostCard post : postBox.getAllPosts()){
            System.out.println(post);
        }
        if(postBox.getAllPosts().isEmpty()){
            System.out.println("No posts yet!");
        }
    }
}
