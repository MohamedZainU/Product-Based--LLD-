/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    static List<BookTickets> bookedTickets = new ArrayList<>();
    
    
    public static void print(){
        for(BookTickets b:bookedTickets){
            System.out.println("Cus ID: "+b.cusID);
            System.out.println("Flight ID: "+b.cusFlight);
            System.out.println("No Of Seats Booked: "+b.cusSeats);
            System.out.println("Price: "+b.price);
        }
    }
    
    public static void cancelTicket(List<Flight> flight){
        System.out.println("Enter FlightID: ");
        int flightCancel = sc.nextInt();
        System.out.println("Enter CusID: ");
        int cusCancel = sc.nextInt();
        int takeFlightID=0,takeSeats=0;
        
        Iterator<BookTickets> iterator = bookedTickets.iterator();
        
        while(iterator.hasNext()){
            BookTickets b = iterator.next();
            if(b.cusFlight==flightCancel && b.cusID==cusCancel){
                takeFlightID = b.cusFlight;
                takeSeats = b.cusSeats;
                System.out.println("Cancelled your Refund Amount is: "+b.price);
                iterator.remove();
                break;
            }
        }
        
        for(Flight f:flight){
            if(f.flightID==takeFlightID){
                f.seats += takeSeats;
                f.price = f.price - 200 * takeSeats;
            }
        }
    }
    
    
    public static List<Flight> createFlights(int n){
        List<Flight> flights = new ArrayList<>();
        for(int i=1;i<=2;i++){
            Flight f = new Flight();
            flights.add(f);
        }
        return flights;
    }
    
    public static void book(List<Flight> flight,int id){
        boolean isIn = false;
        System.out.println("Enter Flight ID");
        int cusFlight = sc.nextInt();
        for(Flight f:flight){
            if(f.flightID==cusFlight){
                isIn = true;
                f.show();
                
                System.out.println("Enter no of Seats");
                int cusSeats = sc.nextInt();
                
                if(f.seats>=cusSeats){
                    BookTickets b = new BookTickets(id,cusFlight,cusSeats,f.price*cusSeats);
                    bookedTickets.add(b);
                    f.increment(cusSeats);
                }else if(f.seats<=0){
                    System.out.println("No Seats Available");
                    return;
                }
                
            }
        }
        
        if(!isIn){
            System.out.println("Please Enter Correct FlightID");
            return;
        }
    }
    
	public static void main(String[] args) {
	    List<Flight> flight = createFlights(2);
		boolean isTrue = true;
		int id = 1;
		while(isTrue){
		    System.out.println("1-> Book Ticket");
		    System.out.println("2-> Cancel Ticket");
		    System.out.println("3-> Print");
		    int choiceInit = sc.nextInt();
		    if(choiceInit==1){
		        book(flight,id);
		        id++;
		    }else if(choiceInit==2){
		        cancelTicket(flight);
		    }else if(choiceInit==3){
		        print();
		    }
		}
	}
}
