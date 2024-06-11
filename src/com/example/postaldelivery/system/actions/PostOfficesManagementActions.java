package com.example.postaldelivery.system.actions;

import java.util.List;

public interface PostOfficesManagementActions {
    boolean addPostOffice(String city);
    boolean removePostOffice(String city);
    List<String> getAllCities();
}