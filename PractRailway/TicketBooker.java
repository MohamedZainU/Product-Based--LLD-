import java.util.*;
public class TicketBooker{
    static int availableL = 3;
    static int availableM = 4;
    static int availableU = 4;
    static int availableSU = 4;
    static int availableSL = 4;
    static int availableRAC = 4;
    static int availableWL = 4;
    
    
    
    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();
    
    static List<Integer> lowerBerthPos = new ArrayList<>(Arrays.asList(1,2,3));
    static List<Integer> middleBerthPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> upperBerthPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> sideUpperBerthPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> sideLowerBerthPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> racPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> waitingPos = new ArrayList<>(Arrays.asList(1,2,3,4));
    static List<Integer> bookList = new ArrayList<>();
    
    static HashMap<Integer,Passenger> mapPass = new HashMap<>();
    
    public static void bookTicketOf(Passenger p,int number,String berthConfirm){
        System.out.println("Booked Succcessfully !");
        p.number = number;
        p.alloted = berthConfirm;
        mapPass.put(p.id,p);
        bookList.add(p.id);
    }
    
    public static void bookTicketRAC(Passenger p,int number,String berthRAC){
        System.out.println("Booked RAC Succcessfully !");
        p.number = number;
        p.alloted = berthRAC;
        mapPass.put(p.id,p);
        racList.add(p.id);
    }
    
    
    public static void bookTicketWL(Passenger p,int number,String berthWL){
        System.out.println("Booked WL Succcessfully !");
        p.number = number;
        p.alloted = berthWL;
        mapPass.put(p.id,p);
        waitingList.add(p.id);
    }
    
    public static void cancel(int passID){
        Passenger passToCancel = mapPass.get(passID);
        int posPasstoCancel = passToCancel.number;
        
        bookList.remove(Integer.valueOf(passID));  //-> don't forget to place Integer.valueOf
        mapPass.remove(Integer.valueOf(passID));
        
        
        if(passToCancel.alloted.equals("L")){
            availableL++;
            lowerBerthPos.add(posPasstoCancel);  //->
        }else if(passToCancel.alloted.equals("M")){
            availableM++;
            middleBerthPos.add(posPasstoCancel);
        }else if(passToCancel.alloted.equals("U")){
            availableU++;
            upperBerthPos.add(posPasstoCancel);
        }else if(passToCancel.alloted.equals("SU")){
            availableSU++;
            sideUpperBerthPos.add(posPasstoCancel);
        }else if(passToCancel.alloted.equals("SL")){
            availableSL++;
            sideLowerBerthPos.add(posPasstoCancel);
        }
        
        
        System.out.println("Cancelled Succcessfully !");
        
        if(racList.size()>0){
            
            Passenger passRACtoCancel = mapPass.get(racList.poll());
            
            int postionRACpos = passRACtoCancel.number;
            
            racPos.add(postionRACpos);
            racList.remove(Integer.valueOf(passRACtoCancel.id));
            
            availableRAC++;  //->
            
            
            
            if(waitingList.size()>0){
                Passenger passWLtoCancel = mapPass.get(waitingList.poll());
                
                int postionWLpos = passWLtoCancel.number;
                
                waitingPos.add(postionWLpos);
                waitingList.remove(Integer.valueOf(passWLtoCancel.id));
                
                passWLtoCancel.number = racPos.get(0);  //->
                passWLtoCancel.alloted = "RAC";   //->
                
                
                racPos.remove(0);
                racList.add(passWLtoCancel.id);
                
                availableRAC--;
                availableWL++;
            }
            
            Main.bookTicket(passRACtoCancel);
        }
        
    }
    
    
    public void print(){
        for(Passenger p:mapPass.values()){
            System.out.println("ID "+p.id);
            System.out.println("Name "+p.name);
            System.out.println("Age "+p.age);
            System.out.println("Alloted "+p.number+p.alloted);
        }
    }
    
}