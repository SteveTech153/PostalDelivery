package System;
import DB.PostOfficesDB;
import java.util.List;

public class Admin extends User implements PostOfficesActions {
    private static final String adminPassword = "Admin@123";
    public Admin(String name, String password) throws IllegalAccessException {
        super(name);
        if(!adminPassword.equals(password)){
            throw new IllegalAccessException("Password is wrong !");
        }
    }
    @Override
    public boolean addPostOffice(String city) {
        city = city.toLowerCase();
        boolean added = true;
        added = added && PostOfficesDB.addCity(city.toLowerCase());
        added = added && PostOfficesDB.createPostOffice(city, new PostOffice(city+" office"));
        try{
            PostMan postMan = new PostMan(city + " post man", "Postman@123", city);
            added = added && PostOfficesDB.addPostManAndCity(postMan, city);
            PostOfficesDB.getAPostOfficeOfACity(city).assignPostMan(postMan);
            if(added) {
                PostOfficesDB.getAPostOfficeOfACity(city).assignManager(new PostalManager(city + " manager", "Postalmanager@123", city));
            }

        }catch(Exception e){
            return false;
        }
        return added;
    }
    @Override
    public boolean removePostOffice(String city){
        return PostOfficesDB.removeCity(city);
    }
}
