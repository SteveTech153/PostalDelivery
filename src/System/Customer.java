package System;

public class Customer extends User implements CustomerPostsActions, CustomerPersonalDetailsActions {
    private static int indexIncrement = 0;
    private int id;
    private Address address;
    private String aadharNumber;
    private final PostBox postBox;
    public Customer(String name, String aadharNumber){
        super(name);
        this.id = ++indexIncrement;
        this.postBox = new PostBox();
        this.aadharNumber = aadharNumber;
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
        PostalManager manager = PostOffice.getManagerOfACity(post.getSenderCity());
        String message = "Your requested city is not available";
        if(manager!=null) {
            message = manager.doPost(post);
        }
        return message;
    }
    @Override
    public String checkStatusOfAPost(String pId){
        PostalManager manager = PostOffice.getManagerOfACity(this.address.getCity());
        if(manager!=null){
            return manager.checkStatusOfAPost(pId);
        }
        return "Post office of your requested city is not available!";
    }
    @Override
    public boolean registerAddress(String name, Address address, int id){
        PostalManager manager = PostOffice.getManagerOfACity(address.getCity());
        if(manager!=null){
            this.address = address;
            return manager.addACustomer(name, address, id);
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
