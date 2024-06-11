package com.example.postaldelivery.system.entities.support;

public class NameAddressPair {
    private String name;
    private Address address;

    public NameAddressPair(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NameAddressPair)) {
            return false;
        }
        NameAddressPair pair = (NameAddressPair) obj;
        return name.equals(pair.name) && address.equals(pair.address);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NameAddressPair{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
