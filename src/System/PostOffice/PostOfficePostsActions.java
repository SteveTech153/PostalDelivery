package System.PostOffice;
import java.util.List;
import System.*;

public interface PostOfficePostsActions {
    String addPost(PostCard post);
    List<PostCard> getAllPosts();
    void setStatusOfADelivery(String pId, String status);
    String getStatusOfADelivery(String pId);
}
