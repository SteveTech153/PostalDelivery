package com.example.postaldelivery.system.entities.core;
import com.example.postaldelivery.system.actions.PostOfficeCustomerActions;
import com.example.postaldelivery.system.actions.PostOfficeManagerActions;
import com.example.postaldelivery.system.actions.PostOfficePostManActions;
import com.example.postaldelivery.system.actions.PostOfficePostsActions;
import com.example.postaldelivery.system.service.PostOfficeService;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostOffice implements PostOfficeCustomerActions, PostOfficeManagerActions, PostOfficePostsActions, PostOfficePostManActions {
    private static int incrementIndex = 0;
    private final String name;
    private final HashMap<Integer, PostCard> posts;
    private HashMap<String, String> statusOfDelivery;
    private List<NameAddressPair> customersDetails;
    private HashMap<NameAddressPair, Integer> customersNameAddressPairAndIdMap;
    private PostalManager manager;
    private PostMan postMan;
    private final PostOfficeService service;

    public PostOffice(String name){
        this.name = name;
        this.manager = null;
        this.posts = new HashMap<>();
        this.statusOfDelivery = new HashMap<>();
        this.customersDetails = new ArrayList<>();
        this.customersNameAddressPairAndIdMap = new HashMap<>();
        this.service = new PostOfficeService(this);
    }
    public HashMap<Integer, PostCard> getPosts(){return posts;}
    public void setIncrementIndex(int newIncrementIndexValue){
        incrementIndex = newIncrementIndexValue;
    }
    public int getIncrementIndex() {return incrementIndex;}
    public List<PostCard> getAllPosts(){
        return new ArrayList<>(posts.values());
    }
    public void setStatusOfDelivery(String pId, String status){this.statusOfDelivery.put(pId, status);}
    public HashMap<String, String> getStatusOfDelivery(){ return this.statusOfDelivery; }
    public HashMap<NameAddressPair, Integer> getCustomersNameAddressPairAndIdMap() { return this.customersNameAddressPairAndIdMap; }
    public List<NameAddressPair> getCustomersDetails() { return this.customersDetails; }
    public void assignManager(PostalManager manager){this.manager = manager;}
    public void assignPostMan(PostMan postMan){this.postMan = postMan;}
    public PostalManager getManager(){return manager;}
    public PostMan getPostMan(){return postMan;}
    public int getIdOfACustomer(NameAddressPair nameAddressPair){return customersNameAddressPairAndIdMap.get(nameAddressPair);}
    public String addPost(PostCard post){return service.addPost(post);}
    public String getStatusOfADelivery(String pId){
        return statusOfDelivery.getOrDefault(pId, "Not available!");
    }
    public void addInCustomersNameAddressPairAndIdMap(NameAddressPair nameAddressPair, int id){customersNameAddressPairAndIdMap.put(nameAddressPair, id);}
    public void setStatusOfADelivery(String pId, String status){
        if(statusOfDelivery.containsKey(pId)){
            statusOfDelivery.put(pId, status);
        }
    }


    public boolean addCustomer(NameAddressPair customerDetails, int id){
        return service.addCustomer(customerDetails, id);
    }

    public Customer getCustomerById(int id){
        return service.getCustomerById(id);
    }

}
