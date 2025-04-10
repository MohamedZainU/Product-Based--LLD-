import java.util.*;
public class Taxi{
    boolean alloted;
    int id;
    char currSpot;
    List<String> listOfRides;
    
    public Taxi(int id,char currSpot){
        this.alloted = false;
        this.id = id;
        this.currSpot = currSpot;
        this.listOfRides = new ArrayList<>();
    }
}