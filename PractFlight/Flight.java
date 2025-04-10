import java.util.*;
public class Flight{
    static int id = 0;// start with 0
    int price;
    int flightID;
    int tickets;
    List<String> passDetails;
    List<Integer> passCost;
    List<Integer> bookedSeats;
    List<Integer> passIDs;
    
    public Flight(){
        price = 5000;
        id = id + 1;
        flightID = id;
        tickets = 50;
        passDetails = new ArrayList<String>();
        passCost = new ArrayList<Integer>();
        bookedSeats = new ArrayList<Integer>();
        passIDs = new ArrayList<Integer>();
    }
    
    public void addPassenger(int passID,int numOfSeats,String trip){
        price+=200*numOfSeats;
        tickets -= numOfSeats;
        passDetails.add(trip);
        passIDs.add(passID);
        passCost.add(price);
        bookedSeats.add(numOfSeats);
    }
    
    
    public void cancel(int passIDCancel){
        int index = passIDs.indexOf(passIDCancel);
        int numOfTickets = bookedSeats.get(index);
        price -= 200 * numOfTickets;
        tickets += numOfTickets;
        passDetails.remove(index);
        System.out.println("Refund Cost "+passCost.get(index));
        bookedSeats.remove(index);
        passIDs.remove(index);
        passCost.remove(index);
    }
    
    
    public void flightSummary(){
        System.out.println("Flight ID "+flightID+" Remaining Seats "+tickets);
    }
    
    public void print(){
        
        for(String s:passDetails){
            System.out.println(s);
        }
    }
}