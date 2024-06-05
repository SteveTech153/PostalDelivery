package System.Customer;
import System.PostCard;

public interface CustomerPostsActions {
    String doPost(PostCard post);
    String checkStatusOfAPost(String pId);
    void checkAllPosts();
}
