import java.util.*;
public class Customer{
    String name;
    static int id = 0;
    int CusID;
    int noOfSeats;
    String seatName;
    int price;
    List<String> seats;
    
    public Customer(String name,int noOfSeats,String seatName,int price,List<String> seats){
        this.name = name;
        this.noOfSeats = noOfSeats;
        this.seatName = seatName;
        this.price = price;
        id = id + 1;
        this.CusID = id;
        this.seats = seats;
    }
}