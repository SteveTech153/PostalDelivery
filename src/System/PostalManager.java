package System;
import DB.PostOfficesDB;

import java.util.List;

public class PostalManager extends User implements PostalManagerCustomerActions, PostalManagerPostsActions {
    private static String postalManagerPassword = "Postalmanager@123";
    private String city;

    public PostalManager(String name, String password, String city) throws IllegalAccessException {
        super(name);
        if (!postalManagerPassword.equals(password)) {
            throw new IllegalAccessException("Password is wrong !");
        }
        this.city = city;
    }

    @Override
    public List<PostCard> getAllPosts() {
        return getPostsOfACity(city);
    }

    @Override
    public String doPost(PostCard post) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(post.getReceiverCity());
        if (postOffice != null) {
            return "Your post will be delivered ASAP. Here is your pId " + postOffice.addPost(post);
        }
        return "Post office of your requested city is not available!";
    }

    @Override
    public String checkStatusOfAPost(String pId) {
        try {
            String destinationCity = PostOfficesDB.getACity(Integer.parseInt(pId.substring(0, 3)));
            if (destinationCity == null) {
                return "Post with pId " + pId + " is not available!";
            }
            if (!destinationCity.equals(city)) {
                PostalManager manager = PostOffice.getManagerOfACity(destinationCity);
                if (manager != null) {
                    return "Status of your post : " + manager.checkStatusOfAPost(pId);
                }
            } else {
                PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
                if (postOffice != null) {
                    return "Status of your post : " + postOffice.getStatusOfADelivery(pId);
                }
            }
        }catch(Exception e) {
            return "Post with pId " + pId + " is not available!";
        }
        return "Post with pId " + pId + " is not available!";
    }
    @Override
    public List<PostCard> getPostsOfACity(String city) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            return postOffice.getAllPosts();
        }
        return null;
    }

    @Override
    public boolean addACustomer(String name, Address address, int id) {
        NameAddressPair customerDetails = new NameAddressPair(name, address);
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            return postOffice.addCustomer(customerDetails, id);
        }
        return false;
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            return postOffice.getIdOfACustomer(nameAddressPair);
        }
        return -1;
    }
    @Override
    public Customer getCustomerById(int id) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            return postOffice.getCustomerById(id);
        }
        return null;
    }
    @Override
    public void setStatusOfADelivery(String pId, String status) {
        PostOffice postOffice = PostOfficesDB.getAPostOfficeOfACity(city);
        if (postOffice != null) {
            postOffice.setStatusOfADelivery(pId, status);
        }
    }
}