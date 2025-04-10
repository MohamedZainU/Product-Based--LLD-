import java.util.*;
public class Taxi{
    boolean alloted;
    static int id = 0;
    int taxiID;
    int freeTime = 6;
    char currSpot = 'A';
    int totalEarnings;
    List<String> taxiList;
    
    public Taxi(){
        currSpot = 'A';
        freeTime = 6;
        alloted = false;
        id = id+1;
        taxiID = id;
        totalEarnings = 0;
        taxiList = new ArrayList<>();
    }
    
    
    public void setDetails(boolean alloted,char currSpot,int freeTime,int totalEarnings,String trip){
        this.alloted = alloted;
        this.currSpot = currSpot;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        taxiList.add(trip);
    }
    
    
    
    public void print(){
       System.out.println("Taxi "+this.taxiID+" Earnings "+this.totalEarnings);
       for(String s:taxiList){
           System.out.println(s);
       }
    }
}