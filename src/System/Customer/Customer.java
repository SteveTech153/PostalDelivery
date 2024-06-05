package System.Customer;
import System.PostalManager.PostalManagerCustomerService;
import System.*;
public class Customer extends User implements CustomerPostsActions, CustomerPersonalDetailsActions {
    private static int indexIncrement = 0;
    private final int id;
    private Address address;
    private final String aadharNumber;
    private final PostBox postBox;
    private final PostalManagerCustomerService postalManagerService;
    public Customer(String name, String aadharNumber, PostalManagerCustomerService postalManagerService){
        super(name);
        this.id = ++indexIncrement;
        this.postBox = new PostBox();
        this.aadharNumber = aadharNumber;
        this.postalManagerService = postalManagerService;
    }
    public String getAadharNumber(){
        return aadharNumber;
    }
    public int getId(){
        return id;
    }
    public PostBox getPostBox(){
        return postBox;
    }

    @Override
    public String doPost(PostCard post){
        String message = "Your requested city is not available";
        if(postalManagerService!=null) {
            message = postalManagerService.doPost(post);
        }
        return message;
    }
    @Override
    public String checkStatusOfAPost(String pId){
        if(postalManagerService!=null){
            return postalManagerService.checkStatusOfAPost(pId);
        }
        return "Post office of your requested city is not available!";
    }
    @Override
    public boolean registerAddress(String name, Address address, int id){
        if(postalManagerService!=null){
            this.address = address;
            return postalManagerService.addACustomer(name, address, id);
        }
        return false;
    }
    @Override
    public void checkAllPosts(){
        for(PostCard post : postBox.getAllPosts()){
            System.out.println(post);
        }
        if(postBox.getAllPosts().size()==0){
            System.out.println("No posts yet!");
        }
    }
}