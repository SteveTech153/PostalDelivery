package com.example.postaldelivery.system.entities.core;
import com.example.postaldelivery.system.service.PasswordService;
import com.example.postaldelivery.system.actions.PostOfficesManagementActions;
import com.example.postaldelivery.system.service.PostOfficesManagementService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Admin extends User implements PostOfficesManagementActions {
    private static final String adminPassword = "rnT190CW1BeiEAOKkj9Xls0Jskbjz2C6Cu11wGRoLvA=";
    private final PasswordService passwordService;
    private final PostOfficesManagementService postOfficesManagementService;
    public Admin(String name, String password) throws IllegalAccessException, NoSuchAlgorithmException {
        super(name);
        this.passwordService = new PasswordService();
        if(!passwordService.checkPassword(password, adminPassword)){
            throw new IllegalAccessException("Password is wrong !");
        }
        this.postOfficesManagementService = new PostOfficesManagementService();
    }

    @Override
    public boolean addPostOffice(String city) {
        return postOfficesManagementService.addPostOffice(city);
    }
    @Override
    public boolean removePostOffice(String city){
        return postOfficesManagementService.removePostOffice(city);
    }
    @Override
    public List<String> getAllCities() {
        return postOfficesManagementService.getAllCities();
    }
}
