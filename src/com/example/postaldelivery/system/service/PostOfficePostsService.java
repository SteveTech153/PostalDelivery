package com.example.postaldelivery.system.service;

import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.actions.PostOfficePostsActions;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.ArrayList;
import java.util.List;

public class PostOfficePostsService implements PostOfficePostsActions {
    private final PostOffice postOffice;
    public PostOfficePostsService(PostOffice postOffice){
        this.postOffice = postOffice;
    }
    @Override
    public List<PostCard> getAllPosts(){
        return new ArrayList<>(postOffice.getPosts().values());
    }
    @Override
    public String addPost(PostCard post){
        int cityId = PostOfficesDB.getIndexOfCity(post.getReceiverCity());
        int lengthOfCityId = Integer.toString(cityId).length();
        if(lengthOfCityId==1){
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1);
            post.setPId("00"+cityId+ (postOffice.getIncrementIndex()));
        }else if(lengthOfCityId==2){
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1);
            post.setPId("0"+cityId+ (postOffice.getIncrementIndex()));
        }else{
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1);
            post.setPId(cityId+""+(postOffice.getIncrementIndex()));
        }
        postOffice.getPosts().put(postOffice.getIncrementIndex(), post);
        postOffice.setStatusOfDelivery(post.getPId(), "Not delivered yet!");
        return post.getPId();
    }
    @Override
    public String getStatusOfADelivery(String pId){
        return postOffice.getStatusOfDelivery().getOrDefault(pId, "Not available!");
    }
    @Override
    public void setStatusOfADelivery(String pId, String status){
        if(postOffice.getStatusOfDelivery().containsKey(pId)){
            postOffice.setStatusOfDelivery(pId, status);
        }
    }

}
