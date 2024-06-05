package System.PostOffice;
import DB.CustomersDB;
import DB.PostOfficesDB;
import System.Customer.Customer;
import System.PostalManager.PostalManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import System.*;
import System.PostMan.*;

public class PostOffice implements PostOfficePostsActions, PostOfficeCustomerActions, PostOfficeManagerActions, PostOfficePostManActions {
    private static int incrementIndex = 0;
    private final String name;
    private HashMap<Integer, PostCard> posts;
    private HashMap<String, String> statusOfDelivery;
    private List<NameAddressPair> customersDetails;
    private HashMap<NameAddressPair, Integer> customersNameAddressPairAndIdMap;
    private PostalManager manager;
    private PostMan postMan;

    public PostOffice(String name){
        this.name = name;
        this.manager = null;
        this.posts = new HashMap<>();
        this.statusOfDelivery = new HashMap<>();
        this.customersDetails = new ArrayList<>();
        this.customersNameAddressPairAndIdMap = new HashMap<>();
    }
    @Override
    public List<PostCard> getAllPosts(){
        return new ArrayList<>(posts.values());
    }
    @Override
    public String addPost(PostCard post){
        int cityId = PostOfficesDB.getIndexOfCity(post.getReceiverCity());
        int lengthOfCityId = Integer.toString(cityId).length();
        if(lengthOfCityId==1){
            post.setPId("00"+cityId+ (++incrementIndex));
        }else if(lengthOfCityId==2){
            post.setPId("0"+cityId+ (++incrementIndex));
        }else{
            post.setPId(cityId+""+(++incrementIndex));
        }
        posts.put(incrementIndex, post);
        statusOfDelivery.put(post.getPId(), "Not delivered yet!");
        return post.getPId();
    }
    @Override
    public void assignManager(PostalManager manager){
        this.manager = manager;
    }
    @Override
    public void assignPostMan(PostMan postMan){
        this.postMan = postMan;
    }
    @Override
    public PostalManager getManager(){
        return manager;
    }
    @Override
    public PostMan getPostMan(){
        return postMan;
    }
    @Override
    public void setStatusOfADelivery(String pId, String status){
        if(statusOfDelivery.containsKey(pId)){
            statusOfDelivery.put(pId, status);
        }
    }
    @Override
    public int getIdOfACustomer(NameAddressPair nameAddressPair){
        return customersNameAddressPairAndIdMap.get(nameAddressPair);
    }
    @Override
    public String getStatusOfADelivery(String pId){
        return statusOfDelivery.getOrDefault(pId, "Not available!");
    }
    public void addInCustomersNameAddressPairAndIdMap(NameAddressPair nameAddressPair, int id){
        customersNameAddressPairAndIdMap.put(nameAddressPair, id);
    }
    @Override
    public boolean addCustomer(NameAddressPair customerDetails, int id){
        if(!this.customersDetails.contains(customerDetails)){
            this.customersDetails.add(customerDetails);
            addInCustomersNameAddressPairAndIdMap(customerDetails, id);
            return true;
        }
        return false;
    }
    @Override
    public Customer getCustomerById(int id){
        return CustomersDB.getCustomerById(id);
    }

}
