package com.example.postaldelivery.system.entities.core;

import com.example.postaldelivery.system.actions.PostManPostsActions;
import com.example.postaldelivery.system.service.PasswordService;
import com.example.postaldelivery.system.actions.PostManDeliveryActions;
import com.example.postaldelivery.system.service.PostManService;

import java.security.NoSuchAlgorithmException;

public class PostMan extends User implements PostManDeliveryActions, PostManPostsActions {
    private final static String postManPassword = "g/xagpiMYzgUcTZFhM67/L8Wvnv73qeo1WxpY+JZEuw=";
    private static int idIndex = 0;
    private final String city;
    private final int id;
    private final PostManService service;
    private final PasswordService passwordService;
    public PostMan(String name, String password, String city, PostManService service) throws IllegalAccessException, NoSuchAlgorithmException {
        super(name);
        this.passwordService = new PasswordService();
        if(!passwordService.checkPassword(password, postManPassword)){
            throw new IllegalAccessException("Password is wrong!");
        }
        this.city = city;
        this.id = ++idIndex;
        this.service = service;
    }
    public static boolean passwordMatches(String password){
        try {
            return new PasswordService().checkPassword(password, postManPassword);
        }catch (Exception e){
            return false;
        }
    }
    public String doDeliveries(){
        return service.doDeliveries();
    }

    public void printAllPosts() {
        service.printAllPosts();
    }
}
