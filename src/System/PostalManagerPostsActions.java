package System;

import DB.PostOfficesDB;

import java.util.List;

public interface PostalManagerPostsActions {
    public List<PostCard> getAllPosts();
    public String doPost(PostCard post);
    public String checkStatusOfAPost(String pId) ;
    public List<PostCard> getPostsOfACity(String city);
    public void setStatusOfADelivery(String pId, String status);
}
