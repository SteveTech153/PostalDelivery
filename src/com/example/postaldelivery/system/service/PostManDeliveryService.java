package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;
import com.example.postaldelivery.system.actions.PostManDeliveryActions;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public class PostManDeliveryService implements PostManDeliveryActions {
    private final PostalManagerPostmanAssistance postalManagerService;
    public PostManDeliveryService(PostalManagerPostmanAssistance postalManagerService){
        this.postalManagerService = postalManagerService;
    }
    @Override
    public String doDeliveries(){
        List<PostCard> posts = null;
        if(postalManagerService!=null) {
            posts = postalManagerService.getAllPosts();
            for(PostCard post : posts){
                int recieverId = postalManagerService.getIdOfACustomer(new NameAddressPair(post.getRecieverName(), post.getReceiverAddress()));
                postalManagerService.getCustomerById(recieverId).getPostBox().addPost(post);
                postalManagerService.setStatusOfADelivery(post.getPId(), "success");
            }
            return "Deliveries done successfully!";
        }
        return "Deliveries failed!";
    }

}
