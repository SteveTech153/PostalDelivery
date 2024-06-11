package com.example.postaldelivery.system.service;

import com.example.postaldelivery.db.PostOfficesDB;
import com.example.postaldelivery.system.assistance.PostalManagerPostmanAssistance;
import com.example.postaldelivery.system.actions.PostOfficesManagementActions;
import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.core.PostalManager;

import java.util.List;

public class PostOfficesManagementService implements PostOfficesManagementActions {
    @Override
    public boolean addPostOffice(String city) {
        city = city.toLowerCase();
        boolean added = true;
        added = added && PostOfficesDB.addCity(city.toLowerCase());
        added = added && PostOfficesDB.createPostOffice(city, new PostOffice(city+" office"));
        try{
            if(added) {
                PostOfficesDB.getAPostOfficeOfACity(city).assignManager(new PostalManager(city + " manager", "Postalmanager@123", city));
            }
            PostalManagerPostmanAssistance postalManagerPostmanService = PostOfficesDB.getManagerOfACity(city);
            PostMan postMan = new PostMan(city + " post man", "Postman@123", city, new PostManService(postalManagerPostmanService));
            added = added && PostOfficesDB.addPostManAndCity(postMan, city);
            PostOfficesDB.getAPostOfficeOfACity(city).assignPostMan(postMan);
        }catch(Exception e){
            return false;
        }
        return added;
    }

    @Override
    public boolean removePostOffice(String city) {
        return PostOfficesDB.removeCity(city);
    }
    @Override
    public List<String> getAllCities() {
        return PostOfficesDB.getCities();
    }
}
