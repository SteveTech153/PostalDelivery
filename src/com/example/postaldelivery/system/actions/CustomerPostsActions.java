package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.support.PostBox;
import com.example.postaldelivery.system.entities.support.PostCard;

public interface CustomerPostsActions {
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId);
    void checkAllPosts(PostBox postBox);
}
