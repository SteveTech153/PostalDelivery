package System.PostMan;

import System.PostalManager.PostalManagerPostmanService;

import java.util.List;
import System.*;

public class PostMan extends User implements PostManDeliveryActions {
    private static String postManPassword = "Postman@123";
    private static int idIndex = 0;
    private String city;
    private int id;
    private PostalManagerPostmanService postalManagerService;
    public PostMan(String name, String password, String city, PostalManagerPostmanService postalManagerService) throws IllegalAccessException {
        super(name);
        if(!passwordMatches(password)){
            throw new IllegalAccessException("Password is wrong!");
        }
        this.city = city;
        this.id = ++idIndex;
        this.postalManagerService = postalManagerService;
    }
    public static boolean passwordMatches(String password){
        return password.equals(postManPassword);
    }
    @Override
    public String doDeliveries(){
        List<PostCard> posts = null;
        if(postalManagerService!=null) {
            posts = postalManagerService.getAllPosts();
            for(PostCard post : posts){
                int recieverId = postalManagerService.getIdOfACustomer(new NameAddressPair(post.getRecieverName(), post.getReceiverAddress()));
                postalManagerService.getCustomerById(recieverId).getPostBox().addPost(post);
                postalManagerService.setStatusOfADelivery(post.getPId(), "success");
            }
            return "Deliveries done successfully!";
        }
        return "Deliveries failed!";
    }

    public void printAllPosts() {
        if(postalManagerService!=null) {
            List<PostCard> posts = postalManagerService.getAllPosts();
            for(PostCard post : posts){
                System.out.println("Post id : "+post.getPId()+" , Sender City : "+post.getSenderCity()+" , Receiver City : "+post.getReceiverCity());
            }
            if(posts.size()==0){
                System.out.println("No posts to deliver!");
            }
        }
    }
}
