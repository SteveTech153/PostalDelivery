package com.example.postaldelivery.system.actions;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public interface PostOfficePostsActions {
    String addPost(PostCard post);
    List<PostCard> getAllPosts();
    void setStatusOfADelivery(String pId, String status);
    String getStatusOfADelivery(String pId);
}
