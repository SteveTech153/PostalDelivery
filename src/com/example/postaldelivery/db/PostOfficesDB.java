package com.example.postaldelivery.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.postaldelivery.system.entities.core.PostMan;
import com.example.postaldelivery.system.entities.core.PostOffice;
import com.example.postaldelivery.system.entities.core.PostalManager;

public class PostOfficesDB {
    private static List<String> cities = new ArrayList<>();
    private static HashMap<String, PostOffice> cityPostOfficeMap = new HashMap<String, PostOffice>();
    private static HashMap<PostMan, String> postManCityMap = new HashMap<PostMan, String>();

    public static List<String> getCities(){
        return cities;
    }
    public static PostOffice getAPostOfficeOfACity(String city){
        return cityPostOfficeMap.getOrDefault(city , null);
    }
    public static boolean addCity(String city){
        if(!cities.contains(city.toLowerCase())){
            cities.add(city.toLowerCase());
            return true;
        }else{
            return false;
        }
    }
    public static String getACity(int index){
        return cities.get(index);
    }
    public static boolean createPostOffice(String city, PostOffice postOffice){
        cityPostOfficeMap.put(city, postOffice);
        return cityPostOfficeMap.containsKey(city);
    }
    public static boolean removeCity(String city){
        if(cities.contains(city)){
            cities.remove(city);
            cityPostOfficeMap.remove(city);
            return true;
        }
        return false;
    }
    public static boolean addPostManAndCity(PostMan postMan, String city){
        if(cities.contains(city)) {
            postManCityMap.put(postMan, city);
            return true;
        }
        return false;
    }
    public static int getIndexOfCity(String city){
        return cities.indexOf(city);
    }

    public static PostalManager getManagerOfACity(String city){
        if(PostOfficesDB.getCities().contains(city))
            return PostOfficesDB.getAPostOfficeOfACity(city).getManager();
        return null;
    }
    public static PostOffice getPostOfficeOfACity(String city){
        if(PostOfficesDB.getCities().contains(city)){
            return PostOfficesDB.getAPostOfficeOfACity(city);
        }
        return null;
    }

}
