package System.PostalManager;

import java.util.List;
import System.*;

public interface PostalManagerPostsActions {
    List<PostCard> getAllPosts();
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId) ;
    List<PostCard> getPostsOfACity(String city);
    void setStatusOfADelivery(String pId, String status);
}