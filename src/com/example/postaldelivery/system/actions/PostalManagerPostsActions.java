package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public interface PostalManagerPostsActions {
    List<PostCard> getAllPosts();
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId) ;
    List<PostCard> getPostsOfACity(String city);
    void setStatusOfADelivery(String pId, String status);
}