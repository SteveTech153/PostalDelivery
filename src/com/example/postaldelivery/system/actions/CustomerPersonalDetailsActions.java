package com.example.postaldelivery.system.actions;

import com.example.postaldelivery.system.entities.support.Address;

public interface CustomerPersonalDetailsActions {
    boolean registerAddress(String name, Address address, int id);
}
