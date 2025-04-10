/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
    static Flight currentFlight = null;
    
    public static void bookTicket(int passID,Flight currentFlight,int numOfSeats){
        String trip = "Passenger ID "+passID+" Number Of Tickets "+numOfSeats+" Price "+numOfSeats*currentFlight.price;
        currentFlight.addPassenger(passID,numOfSeats,trip);
        currentFlight.flightSummary();
    }
    
    // public static void cancel(Flight currentFlight,int passIDtoCancel){
        
    // }
    
    
	public static void main(String[] args) {
		List<Flight> flight = new ArrayList<>();
		
		int passID = 1;//
		
		for(int i=0;i<2;i++){
		    flight.add(new Flight());
		}
		
		boolean loop = true;
		while(loop){
		    System.out.println("1-> Book Ticket");
		    System.out.println("2-> Cancel Ticket");
		    System.out.println("3-> Print Ticket");
		    int choiceOf = sc.nextInt();
		    if(choiceOf==1){
		        
		        System.out.println("Enter Flight ID");
		        
		        int flightID = sc.nextInt();
		        
		        if(flightID > flight.size()){
		            System.out.println("No Flight Available !");
		            break;
		        }
		        
		        for(Flight f:flight){
		            if(f.flightID == flightID){
		                currentFlight = f;
		                f.flightSummary();
		                break;
		            }
		        }
		        
		        System.out.println("Enter Number of Seats");
		        int numOfSeats = sc.nextInt();
		        
		        if(numOfSeats > currentFlight.tickets){
		            System.out.println("No Flight Available");
		            break;
		        }
		        
		        bookTicket(passID,currentFlight,numOfSeats);
		        
		        passID++;
		        
		    }else if(choiceOf==2){
		        System.out.println("Enter Flight ID");
		        int fID = sc.nextInt();
		        for(Flight f:flight){
		            if(f.flightID==fID){
		                currentFlight = f;
		                break;
		            }
		        }
		        
		        System.out.println("Enter Passenger ID");
		        int passIDtoCancel = sc.nextInt();
		        currentFlight.cancel(passIDtoCancel);
		        
		    }else if(choiceOf==3){
		        for(Flight f:flight){  //correct format for print
		            f.print();
		        }
		    }else{
		        loop = false;
		    }
		}
	}
}

//remember to use indexOf to get index to delete passIDs declare currentFlight static above all as null print use for each to print check if flightID==f.id usinf for loop for cancel and booking
