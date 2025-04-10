/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    static int childCount = 0;
    
    static List<Passenger> bookedTickets = new ArrayList<>();
    
    
    public static void cancelTicket(){
        TicketBooker ticketCancel = new TicketBooker();
        System.out.println("Enter Passenger ID");
        int passIdToCancel = sc.nextInt();
        ticketCancel.cancel(passIdToCancel);
    }
    
    
    public static void print(){
        TicketBooker ticketPrint = new TicketBooker();
        ticketPrint.print();
    }
    
    
    public static void availablity(Passenger p){
        TicketBooker ticket = new TicketBooker();
        
        
        if(p.agePass>60){
            p.berthPass = "L";
        }
        
        if(p.agePass<18){
            childCount++;
            if(childCount==2){
                p.berthPass = "L";
                childCount = 3;
            }
        }
        
        
        if((p.berthPass.equals("L") && ticket.lowerAvail==0) || 
           (p.berthPass.equals("M") && ticket.middleAvail==0) ||
           (p.berthPass.equals("U") && ticket.upperAvail==0) ||
           (p.berthPass.equals("SU") && ticket.sideUpperAvail==0) ||
           (p.berthPass.equals("SL") && ticket.sideLowerAvail==0)){
               System.out.println("Available Tickets: ");
               System.out.println("Lower Berth: "+ticket.lowerAvail);
               System.out.println("Middle Berth: "+ticket.middleAvail);
               System.out.println("Upper Berth: "+ticket.upperAvail);
               System.out.println("Side Upper Berth: "+ticket.sideUpperAvail);
               System.out.println("Side Lower Berth: "+ticket.sideLowerAvail);
               
               String choiceBerth = sc.next();
               p.berthPass = choiceBerth;
           }
        
        
        
        
        if(ticket.lowerAvail==0 && ticket.upperAvail==0 && ticket.middleAvail==0 && ticket.sideUpperAvail==0 && ticket.sideLowerAvail==0){
            if(ticket.racAvail>0){
                System.out.println("Tickets Sold Out Booking On RAC");
                ticket.bookTicketRAC(p,"RAC",ticket.racPos.get(0));
                ticket.racAvail--;
                ticket.racPos.remove(0);
            }else if(ticket.wlAvail>0){
                System.out.println("RAC Over Booking On Waiting List");
                ticket.bookTicketWL(p,"WL",ticket.wlPos.get(0));
                ticket.wlAvail--;
                ticket.wlPos.remove(0);
            }else{
                System.out.println("No Tickets Available");
            }
        }
        
        
        if(p.berthPass.equals("L") && ticket.lowerAvail>0){
            ticket.bookTicketOf(p,"L",ticket.lowerBerthPos.get(0));
            ticket.lowerAvail--;
            ticket.lowerBerthPos.remove(0);
        }else if(p.berthPass.equals("M") && ticket.middleAvail>0){
            ticket.bookTicketOf(p,"M",ticket.middleBerthPos.get(0));
            ticket.middleAvail--;
            ticket.middleBerthPos.remove(0);
        }else if(p.berthPass.equals("U") && ticket.upperAvail>0){
            ticket.bookTicketOf(p,"U",ticket.upperBerthPos.get(0));
            ticket.upperAvail--;
            ticket.upperBerthPos.remove(0);
        }else if(p.berthPass.equals("SU") && ticket.sideUpperAvail>0){
            ticket.bookTicketOf(p,"SU",ticket.sideUpperBerthPos.get(0));
            ticket.sideUpperAvail--;
            ticket.sideUpperBerthPos.remove(0);
        }else if(p.berthPass.equals("SL") && ticket.sideLowerAvail>0){
            ticket.bookTicketOf(p,"SL",ticket.sideLowerBerthPos.get(0));
            ticket.sideLowerAvail--;
            ticket.sideLowerBerthPos.remove(0);
        }
    }
    
    
    public static void bookTicket(){
        System.out.println("Enter your Name");
        String passName = sc.next();
        System.out.println("Enter your Age");
        int agePass = sc.nextInt();
        System.out.println("Enter your Berth preference (L,M,U)");
        String berthPass = sc.next();
        Passenger p = new Passenger(passName,agePass,berthPass);
        availablity(p);
        bookedTickets.add(p);
    }
    
	public static void main(String[] args) {
	    boolean isTrue = true;
	    
	    while(isTrue){
	        System.out.println("1-> Book Ticket");
	        System.out.println("2-> Cancel Ticket");
	        System.out.println("3-> Print");
	        int choiceInit = sc.nextInt();
	        if(choiceInit==1){
	            bookTicket();
	        }else if(choiceInit==2){
	            cancelTicket();
	        }else if(choiceInit==3){
	            print();
	        }
	    }
	}
}
