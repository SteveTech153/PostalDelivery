package System.Admin;
import DB.PostOfficesDB;
import System.PostMan.PostMan;
import System.PostOffice.PostOffice;
import System.PostalManager.PostalManager;
import System.User;
import java.util.List;

public class Admin extends User implements PostOfficesManagementActions {
    private static final String adminPassword = "Admin@123";
    public Admin(String name, String password) throws IllegalAccessException {
        super(name);
        if(!passwordMatches(password)){
            throw new IllegalAccessException("Password is wrong !");
        }
    }
    public static boolean passwordMatches(String password){
        return adminPassword.equals(password);
    }
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
            PostMan postMan = new PostMan(city + " post man", "Postman@123", city, PostOfficesDB.getManagerOfACity(city));
            added = added && PostOfficesDB.addPostManAndCity(postMan, city);
            PostOfficesDB.getAPostOfficeOfACity(city).assignPostMan(postMan);
        }catch(Exception e){
            return false;
        }
        return added;
    }
    @Override
    public boolean removePostOffice(String city){
        return PostOfficesDB.removeCity(city);
    }

    public List<String> getAllCities() {
        return PostOfficesDB.getCities();
    }
}
