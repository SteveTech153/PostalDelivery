package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.actions.PostOfficeManagerActions;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.core.PostalManager;

public class PostOfficeManagerService implements PostOfficeManagerActions {
    private PostOffice postOffice;
    public PostOfficeManagerService(PostOffice postOffice){
        this.postOffice = postOffice;
    }
    @Override
    public void assignManager(PostalManager manager){
        postOffice.assignManager(manager);
    }
    @Override
    public PostalManager getManager() {
        return postOffice.getManager();
    }

}
