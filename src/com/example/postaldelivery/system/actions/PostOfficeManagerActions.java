package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.core.PostalManager;

public interface PostOfficeManagerActions {
    void assignManager(PostalManager manager);
    PostalManager getManager();
}
