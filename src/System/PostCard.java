package System;

public class PostCard {
    private Address from;
    private Address to;
    private String message;
    private String pId;
    public PostCard(Address from, Address to, String message){
        this.from = from;
        this.to = to;
        this.message = message;
        pId = "";
    }
    public void setPId(String pId){
        this.pId = pId;
    }
    public String getPId(){
        return pId;
    }
    public String getSenderCity(){
        return from.getCity();
    }
    public String getReceiverCity(){
        return to.getCity();
    }
    public String getRecieverName(){
        return to.getName();
    }
    public Address getReceiverAddress(){
        return to;
    }
    @Override
    public String toString(){
        return "From: " +from + "\nTo: " + to + "\nMessage: " + message;
    }
}
