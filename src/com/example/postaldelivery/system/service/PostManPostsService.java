package com.example.postaldelivery.system.service;
import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;
import com.example.postaldelivery.system.actions.PostManPostsActions;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public class PostManPostsService implements PostManPostsActions {
    private final PostalManagerPostmanAssistance postalManagerService;
    public PostManPostsService(PostalManagerPostmanAssistance postalManagerService) {
        this.postalManagerService = postalManagerService;
    }
    @Override
    public void printAllPosts() {
        if (postalManagerService != null) {
            List<PostCard> posts = postalManagerService.getAllPosts();
            for (PostCard post : posts) {
                System.out.println("Post id : " + post.getPId() + " , Sender City : " + post.getSenderCity() + " , Receiver City : " + post.getReceiverCity());
            }
            if (posts.size() == 0) {
                System.out.println("No posts to deliver!");
            }
        }
    }
}