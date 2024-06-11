package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.actions.PostManDeliveryActions;
import com.example.postaldelivery.system.actions.PostManPostsActions;
import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;

public class PostManService implements PostManDeliveryActions, PostManPostsActions {
    private final PostalManagerPostmanAssistance postalManagerService;
    private final PostManDeliveryService postManDeliveryService;
    private final PostManPostsService postManPostsService;

    public PostManService(PostalManagerPostmanAssistance postalManagerService) {
        this.postalManagerService = postalManagerService;
        this.postManDeliveryService = new PostManDeliveryService(postalManagerService);
        this.postManPostsService = new PostManPostsService(postalManagerService);
    }

    public String doDeliveries() {
        return postManDeliveryService.doDeliveries();
    }
    public void printAllPosts() {
        postManPostsService.printAllPosts();
    }
}
