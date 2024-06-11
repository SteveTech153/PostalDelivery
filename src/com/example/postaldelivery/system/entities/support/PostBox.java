package com.example.postaldelivery.system.entities.support;

import java.util.ArrayList;
import java.util.List;

public class PostBox {
    List<PostCard> posts = new ArrayList<PostCard>();
    public void addPost(PostCard post){
        posts.add(post);
    }
    public List<PostCard> getAllPosts(){
        return posts;
    }
}
