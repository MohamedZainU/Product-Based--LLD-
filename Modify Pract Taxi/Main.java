/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    public static void bookTaxi(int id,int pickupTime,char pickup,char drop,List<Taxi> freeTaxi){
        String trip = "";
        int min = 999;
        char nextSpot = 'Z';
        int nextFreetime = 0;
        int earnings =0;
        Taxi booked = null;
        int distBtwPickDrop =0;
        for(Taxi t:freeTaxi){
            int distBtwCus = Math.abs((t.currSpot-'0')-(pickup-'0'))*15;
            if(distBtwCus<min){
                booked = t;
                distBtwPickDrop = Math.abs((drop-'0')-(pickup-'0'))*15;
                earnings = (distBtwPickDrop-5)*10+100;
                int dropTime = pickupTime+distBtwPickDrop/15;
                nextFreetime = dropTime;
                nextSpot = drop;
                trip = id + "  " + id + "  " + pickup + "  " + drop + "  " + pickupTime + "  " + dropTime + "  " + earnings;
                min = distBtwCus;
            }
        }
        booked.setDetails(true,nextSpot,nextFreetime,booked.totalEarnings+earnings,trip);
        System.out.println("Taxi "+booked.taxiID+" can be allocated");
    }
    
    
    
    
    public static List<Taxi> createTaxi(int n){
        List<Taxi> taxis = new ArrayList<>();
        for(int i=0;i<n;i++){
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }
    
    public static List<Taxi> free(int pickupTime,char pickup,char drop,List<Taxi> taxi){
        List<Taxi> freeTaxi = new ArrayList<>();
        for(Taxi t:taxi){
            if(t.freeTime<=pickupTime && (Math.abs(t.currSpot-'0')-(pickup-'0')<= pickupTime - t.freeTime)){
                freeTaxi.add(t);
            }
        }
        return freeTaxi;
    }
    
	public static void main(String[] args) {
	    List<Taxi> taxi = createTaxi(4);
		boolean isTrue = true;
		int id = 1;
		
		while(isTrue){
		    System.out.println("1-> Book Taxi");
		    System.out.println("2-> Print");
		    int choiceInit = sc.nextInt();
		    if(choiceInit==1){
		    System.out.println("Enter pickup time");
		    int pickupTime = sc.nextInt();
		    System.out.println("Enter pickup point");
		    char pickup = sc.next().charAt(0);
		    System.out.println("Enter drop point");
		    char drop = sc.next().charAt(0);
		    
		    if(pickup<'A' || drop>'E' || pickup>'E' || drop<'A'){
		        System.out.println("No Taxi Available in that Loaction");
		        return;
		    }
		    
		    List<Taxi> freeTaxi = free(pickupTime,pickup,drop,taxi);
		    
		    if(freeTaxi.size()==0){
		        System.out.println("No Taxi Can be Allocated");
		    }
		    
		    Collections.sort(freeTaxi,(a,b) -> a.totalEarnings-b.totalEarnings);
		    
		    bookTaxi(id,pickupTime,pickup,drop,freeTaxi);
		    
		    id++;
		    
		    
		    }else if(choiceInit==2){
		        for(Taxi t:taxi){
		            t.print();
		        }
		    }else{
		        isTrue = false;
		    }
		}
	}
}
