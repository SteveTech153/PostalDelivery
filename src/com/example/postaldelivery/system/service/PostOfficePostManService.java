package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.actions.PostOfficePostManActions;
import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.system.entities.core.PostOffice;

public class PostOfficePostManService implements PostOfficePostManActions {
    private PostOffice postOffice;
    public  PostOfficePostManService(PostOffice postOffice){
        this.postOffice = postOffice;
    }
    @Override
    public void assignPostMan(PostMan postMan){
        postOffice.assignPostMan(postMan);
    }
    @Override
    public PostMan getPostMan(){
        return postOffice.getPostMan();
    }
}
