/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
    static int countOf = 0;
    
    public static void bookTicket(Passenger p){
        TicketBooker ticket = new TicketBooker();
        
        if(p.age>60){
            p.berthName = "L";
        }else if(p.age<16 && countOf<=1){
            countOf++;
            if(countOf>1){
                countOf = 128;
                System.out.println("Lower Berth can be given");
                p.berthName = "L";
            }
        }
        
        
        
        if(p.berthName.equals("L") && TicketBooker.availableL <= 0 ||
           p.berthName.equals("M") && TicketBooker.availableM <= 0 ||
           p.berthName.equals("U") && TicketBooker.availableU <= 0 ||
           p.berthName.equals("SU") && TicketBooker.availableSU <= 0 ||
           p.berthName.equals("SL") && TicketBooker.availableSL <=0){
               System.out.println("Your Prefered Bertyh Not Available");
               System.out.println("Available L "+TicketBooker.availableL);
               System.out.println("Available M "+TicketBooker.availableM);
               System.out.println("Available U "+TicketBooker.availableU);
               System.out.println("Available SU "+TicketBooker.availableSU);
               System.out.println("Available SL "+TicketBooker.availableSL);
               
               String secondPreference = sc.next();
               p.berthName = secondPreference;
           }
           
           
        
        
        if(p.berthName.equals("L") && TicketBooker.availableL > 0 ||
           p.berthName.equals("M") && TicketBooker.availableM > 0 ||
           p.berthName.equals("U") && TicketBooker.availableU > 0 ||
           p.berthName.equals("SU") && TicketBooker.availableSU > 0 ||
           p.berthName.equals("SL") && TicketBooker.availableSL > 0){
               
        
        
        if(p.berthName.equals("L") && TicketBooker.availableL > 0){
            TicketBooker.bookTicketOf(p,TicketBooker.lowerBerthPos.get(0),"L");
            TicketBooker.availableL--;
            TicketBooker.lowerBerthPos.remove(0);
        }else if(p.berthName.equals("M")&& TicketBooker.availableM > 0){
            TicketBooker.bookTicketOf(p,TicketBooker.middleBerthPos.get(0),"M");
            TicketBooker.availableM--;
            TicketBooker.middleBerthPos.remove(0);
        }else if(p.berthName.equals("U")&& TicketBooker.availableU > 0){
            TicketBooker.bookTicketOf(p,TicketBooker.upperBerthPos.get(0),"U");
            TicketBooker.availableU--;
            TicketBooker.upperBerthPos.remove(0);
        }else if(p.berthName.equals("SU")&& TicketBooker.availableSU > 0){
            TicketBooker.bookTicketOf(p,TicketBooker.sideUpperBerthPos.get(0),"SU");
            TicketBooker.availableSU--;
            TicketBooker.sideUpperBerthPos.remove(0);
        }else if(p.berthName.equals("SL")&& TicketBooker.availableSL > 0){
            TicketBooker.bookTicketOf(p,TicketBooker.sideLowerBerthPos.get(0),"SL");
            TicketBooker.availableSL--;
            TicketBooker.sideLowerBerthPos.remove(0);
        }
        
        
        }else{
            if(TicketBooker.availableRAC > 0){
                System.out.println("RAC Only Available !");
                TicketBooker.bookTicketRAC(p,TicketBooker.racPos.get(0),"RAC");
                TicketBooker.availableRAC--;
                TicketBooker.racPos.remove(0);
            }else if(TicketBooker.availableWL > 0){
                System.out.println("WaitingList Only Available !");
                TicketBooker.bookTicketWL(p,TicketBooker.waitingPos.get(0),"WL");
                TicketBooker.availableWL--;
                TicketBooker.waitingPos.remove(0);
            }
        }
        
    }
    
    
	public static void main(String[] args) {
		boolean loop = true;
		while(loop){
		    System.out.println("1-> Book Ticket");
		    System.out.println("2-> Cancel Ticket");
		    System.out.println("3-> Print Ticket");
		    int choiceOfUser = sc.nextInt();
		    if(choiceOfUser==1){
		        
		        System.out.println("Enter name");
		        String nameOfPass = sc.next();
		        System.out.println("Enter Age");
		        int ageOfPass = sc.nextInt();
		        System.out.println("Enter preference (L,M,U)");
		        String preference = sc.next();
		        Passenger p = new Passenger(nameOfPass,ageOfPass,preference);
		        
		        bookTicket(p);
		        
		        
		        
		    }else if(choiceOfUser==2){
		        TicketBooker ticket = new TicketBooker();
		        System.out.println("Enter Passenger ID to cancel");
		        int passID = sc.nextInt();
		        ticket.cancel(passID);
		        
		    }else if(choiceOfUser==3){
		        TicketBooker ticket = new TicketBooker();
		        ticket.print();
		    }else{
		        loop = false;
		    }
		}
	}
}
