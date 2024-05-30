package System;

public interface CustomerPostsActions {
    public String doPost(PostCard post);
    public String checkStatusOfAPost(String pId);
    public void checkAllPosts();
}
