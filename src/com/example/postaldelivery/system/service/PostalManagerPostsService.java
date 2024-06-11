package com.example.postaldelivery.system.service;

import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.actions.PostalManagerPostsActions;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.core.PostalManager;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public class PostalManagerPostsService implements PostalManagerPostsActions {
    private final String postalManagerCity;
    public PostalManagerPostsService(String city){
        this.postalManagerCity = city;
    }
    @Override
    public List<PostCard> getAllPosts() {
        return getPostsOfACity(postalManagerCity);
    }
    @Override
    public String doPost(PostCard post) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(post.getReceiverCity());
        if (postOffice != null) {
            if(post.getSenderAddress().equals(post.getReceiverAddress())){
                return "Sender and receiver address can't be same!";
            }
            return "Your post will be delivered ASAP. Here is your pId " + postOffice.addPost(post);
        }
        return "Post office of your requested city is not available!";
    }

    @Override
    public String checkStatusOfAPost(String pId) {
        try {
            String destinationCity = PostOfficesDB.getACity(Integer.parseInt(pId.substring(0, 3)));
            if (destinationCity == null) {
                return "Post with pId " + pId + " is not available!";
            }
            if (!destinationCity.equals(postalManagerCity)) {
                PostalManager manager = PostOfficesDB.getManagerOfACity(destinationCity);
                if (manager != null) {
                    return "Status of your post : " + manager.checkStatusOfAPost(pId);
                }
            } else {
                PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(postalManagerCity);
                if (postOffice != null) {
                    return "Status of your post : " + postOffice.getStatusOfADelivery(pId);
                }
            }
        }catch(Exception e) {
            return "Post with pId " + pId + " is not available!";
        }
        return "Post with pId " + pId + " is not available!";
    }
    @Override
    public List<PostCard> getPostsOfACity(String city) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            return postOffice.getAllPosts();
        }
        return null;
    }
    @Override
    public void setStatusOfADelivery(String pId, String status) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(postalManagerCity);
        if (postOffice != null) {
            postOffice.setStatusOfADelivery(pId, status);
        }
    }
}
