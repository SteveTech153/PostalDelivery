package System;

import java.util.List;

public interface PostOfficePostsActions {
    public String addPost(PostCard post);
    public List<PostCard> getAllPosts();
    public void setStatusOfADelivery(String pId, String status);
    public String getStatusOfADelivery(String pId);
}
