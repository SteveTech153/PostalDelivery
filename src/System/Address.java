package System;

public class Address {
    private String name;
    private String address;
    private String city;
    private String pincode;
    public Address(String name, String address, String city, String pincode){
        this.name = name;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getPincode(){
        return pincode;
    }
    public void setCity(String city){
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Address){
            Address a = (Address) obj;
            return a.address.equals(address) && a.city.equals(city) && a.pincode.equals(pincode);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return address.hashCode() + city.hashCode() + pincode.hashCode();
    }
    @Override
    public String toString() {
        return name + ", " + address + ", " + city + ", " + pincode;
    }
}
