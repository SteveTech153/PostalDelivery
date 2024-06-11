package com.example.postaldelivery.system.assistance;

import com.example.postaldelivery.system.entities.core.Customer;
import com.example.postaldelivery.system.entities.support.NameAddressPair;
import com.example.postaldelivery.system.entities.support.PostCard;

import java.util.List;

public interface PostalManagerPostmanAssistance {
    List<PostCard> getPostsOfACity(String city);
    void setStatusOfADelivery(String pId, String status);
    int getIdOfACustomer(NameAddressPair nameAddressPair);
    Customer getCustomerById(int id);
    List<PostCard> getAllPosts();
}
