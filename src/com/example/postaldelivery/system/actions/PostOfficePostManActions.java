package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.core.PostMan;

public interface PostOfficePostManActions {
    void assignPostMan(PostMan postMan);
    PostMan getPostMan();
}
