import java.util.*;
public class TicketBooker{
    static int lowerAvail = 4;
    static int middleAvail = 3;
    static int upperAvail = 0;
    static int sideUpperAvail = 0;
    static int sideLowerAvail = 1;
    static int racAvail = 1;
    static int wlAvail = 2;
    
    static HashMap<Integer,Passenger> bookList = new HashMap<>();
    
    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> wlList = new LinkedList<>();
    
    
    static List<Integer> lowerBerthPos = new ArrayList<>(Arrays.asList(1,6,11,16));
    static List<Integer> middleBerthPos = new ArrayList<>(Arrays.asList(2,7,12,17));
    static List<Integer> upperBerthPos = new ArrayList<>(Arrays.asList(3,8,13,18));
    static List<Integer> sideUpperBerthPos = new ArrayList<>(Arrays.asList(4,9,14,19));
    static List<Integer> sideLowerBerthPos = new ArrayList<>(Arrays.asList(5,10,15,20));
    static List<Integer> racPos = new ArrayList<>(Arrays.asList(24,25));
    static List<Integer> wlPos = new ArrayList<>(Arrays.asList(29,30));
    
    public static void cancel(int passID){
        Passenger p = bookList.get(passID);
        
        if(p.berthPass.equals("L")){
            lowerAvail++;
            lowerBerthPos.add(p.seatNo);
        }else if(p.berthPass.equals("M")){
            middleAvail++;
            middleBerthPos.add(p.seatNo);
        }else if(p.berthPass.equals("U")){
            upperAvail++;
            upperBerthPos.add(p.seatNo);
        }else if(p.berthPass.equals("SU")){
            sideUpperAvail++;
            sideUpperBerthPos.add(p.seatNo);
        }else if(p.berthPass.equals("SL")){
            sideLowerAvail++;
            sideLowerBerthPos.add(p.seatNo);
        }else if(p.berthPass.equals("RAC")){
            racAvail++;
            racPos.add(p.seatNo);
        }else if(p.berthPass.equals("WL")){
            wlAvail++;
            wlPos.add(p.seatNo);
        }
        
        bookList.remove(Integer.valueOf(passID));
        
        if(racList.size()>0){
            Passenger racPass = bookList.get(racList.poll());
            
            racList.remove(0);
            racAvail++;
            racPos.add(p.seatNo);
            
            racPass.berthPass = p.berthPass;
            racPass.seatNo = p.seatNo;
            
            if(wlList.size()>0){
            Passenger wlPass = bookList.get(wlList.poll());
            
            wlList.remove(0);
            wlAvail++;
            wlPos.add(p.seatNo);
            
            
            wlPass.berthPass = "RAC";
            wlPass.seatNo = racPos.get(0);
            
            racList.add(wlPass.passID);
            racAvail--;
            
            
            }
        }
    }
    
    public static void print(){
        boolean isIn = false;
        
        
        for(Passenger p:bookList.values()){
            isIn = true;
            System.out.println("-----------------------");
            System.out.println("Pass ID "+p.passID);
            System.out.println("Name "+p.passName);
            System.out.println("Age "+p.agePass);
            System.out.println("Berth "+p.berthPass);
            System.out.println("Seat No "+p.seatNo);
            System.out.println("------------------------");
        }
        
        if(!isIn){
            System.out.println("No Booked Tickets Available !");
        }
    }
    
    
    public static void bookTicketOf(Passenger p,String berth,int seatNo){
        p.berthPass = berth;
        p.seatNo = seatNo;
        bookList.put(p.passID,p);
    }
    
    public static void bookTicketRAC(Passenger p,String berth,int seatNo){
        p.berthPass = berth;
        p.seatNo = seatNo;
        racList.add(p.passID);
        bookList.put(p.passID,p);
    }
    
    public static void bookTicketWL(Passenger p,String berth,int seatNo){
        p.berthPass = berth;
        p.seatNo = seatNo;
        wlList.add(p.passID);
        bookList.put(p.passID,p);
    }
    
}