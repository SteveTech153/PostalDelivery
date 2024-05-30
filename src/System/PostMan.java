package System;

import DB.CustomersDB;

import java.util.List;

public class PostMan extends User implements DeliveryActions {
    private static String postManPassword = "Postman@123";
    private static int idIndex = 0;
    private String city;
    private int id;

    public PostMan(String name, String password, String city) throws IllegalAccessException {
        super(name);
        if(!postManPassword.equals(password)){
            throw new IllegalAccessException("Password is wrong!");
        }
        this.city = city;
        this.id = ++idIndex;
    }
    public static boolean passwordMatches(String password){
        return password.equals(postManPassword);
    }
    @Override
    public void doDeliveries(){
        PostOffice postOffice = PostOffice.getPostOfficeOfACity(city);
        List<PostCard> posts = null;
        if(postOffice!=null) {
            PostalManager manager = postOffice.getManager();
            posts = manager.getAllPosts();
            for(PostCard post : posts){
                int recieverId = manager.getIdOfACustomer(new NameAddressPair(post.getRecieverName(), post.getReceiverAddress()));
                manager.getCustomerById(recieverId).getPostBox().addPost(post);
                manager.setStatusOfADelivery(post.getPId(), "success");
            }
        }
    }

}
