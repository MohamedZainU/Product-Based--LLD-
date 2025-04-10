import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    static List<Customer> customerList = new ArrayList<>();
    
    static HashMap<String,List<Customer>> map = new HashMap<>();
    
    
    public static void print(){
        
        System.out.println("Enter your name To Search: ");
        String nameOfSearch = sc.next();
        
        
        for(Map.Entry<String,List<Customer>> res:map.entrySet()){
            String nameToSearch = res.getKey();
            if(nameToSearch.equals(nameOfSearch)){
                System.out.println("----------------------------------------");
                List<Customer> cust = res.getValue();
                
                for(Customer c:cust){
                    System.out.println("----------------------------------------");
                    System.out.println("Name: "+c.name);
                    System.out.println("Booking ID: "+c.CusID);
                    System.out.println("No Of Seats: "+c.noOfSeats);
                    System.out.println("Seat Name: "+c.seatName);
                    for(String s:c.seats){
                        System.out.print(s+" ");
                    }
                    System.out.println();
                    System.out.println("Price: "+c.price);
                    System.out.println("----------------------------------------");
                }
                System.out.println("----------------------------------------");
            }
        }
    }
    
    
    public static void confirmBook(String str,String nameOf){
        Movies m = new Movies();
        
        if(!map.containsKey(nameOf)){
	        map.put(nameOf,new ArrayList<>());
	    }
        
        if(m.availableDiamond<=0 && str.equals("Diamond")){
            System.out.println("Diamond Seats are Over");
            return;
        }else if(m.availableGold<=0 && str.equals("Gold")){
            System.out.println("Gold Seats are Over");
            return;
        }
        List<String> diamondAllot = new ArrayList<>();
        List<String> goldAllot = new ArrayList<>();
        
        System.out.println();
        
        if(str.equals("Diamond")){
            
            System.out.println("Enter No of Diamond Seats Again");
            int seatsOfDiamond = sc.nextInt();
            
            if(seatsOfDiamond<=m.availableDiamond){
            
            for(int i=1;i<=seatsOfDiamond;i++){
                diamondAllot.add(m.diamondSeats.get(i-1));
            }
                
            for(int i=1;i<=seatsOfDiamond;i++){
                m.diamondSeats.remove(0);
            }
            
            m.availableDiamond -= seatsOfDiamond;
            int priceOfTicketDiamond = seatsOfDiamond*150;
            
            Customer c0 = new Customer(nameOf,seatsOfDiamond,"Diamond",priceOfTicketDiamond,diamondAllot);
            customerList.add(c0);
            
            map.get(nameOf).add(c0);
            
            }else{
                System.out.println("Not Available !");
                
                
                System.out.println("----------------------");
                System.out.println("Showing Available Diamond");
                System.out.println("----------------------");
                
                for(String s:m.diamondSeats){
                    System.out.print(s+" ");
                }
                
                confirmBook("Diamond",nameOf);
                
                
                
            }
        }else if(str.equals("Gold")){
            
            System.out.println("Enter No of Gold Seats Again");
            int seatsOfGold = sc.nextInt();
            
            if(seatsOfGold<=m.availableGold){
            
            
            for(int i=1;i<=seatsOfGold;i++){
                goldAllot.add(m.goldSeats.get(i-1));
            }
                
            for(int i=1;i<=seatsOfGold;i++){
                m.goldSeats.remove(0);
            }
            
            m.availableGold -= seatsOfGold;
            
            int priceOfTicketGold = seatsOfGold*130;
            
            Customer c1 = new Customer(nameOf,seatsOfGold,"Gold",priceOfTicketGold,goldAllot);
            customerList.add(c1);
            
            map.get(nameOf).add(c1);
            
            
            
            }else{
                System.out.println("Not Availbale !");
                
                System.out.println("----------------------");
                System.out.println("Showing Available Gold");
                System.out.println("----------------------");
                
                for(String s:m.goldSeats){
                    System.out.print(s+" ");
                }
                
                confirmBook("Gold",nameOf);
                
                
            }
        }
    }
    
    
    
    
    
    
    
    public static void book(){
        Movies m = new Movies();
        System.out.println("Enter your Name");
	    String nameOf = sc.next();
	    
	    if(!map.containsKey(nameOf)){
	        map.put(nameOf,new ArrayList<>());
	    }
        if(m.availableDiamond > 0 || m.availableGold > 0){
            
        System.out.println("1-> Diamond ₹150");
        System.out.println("2-> Gold ₹130");
        int userPref = sc.nextInt();
        if(userPref==1){
            if(m.availableDiamond <= 0){
            System.out.println("No Diamond Seats Available");
            return;
            }
            List<String> diamondAllot = new ArrayList<>();
            
            
            System.out.println("Enter No of Seats");
            int seatsOfDiamond = sc.nextInt();
            
            if(seatsOfDiamond<=m.availableDiamond){
                
            for(int i=1;i<=seatsOfDiamond;i++){
                diamondAllot.add(m.diamondSeats.get(i-1));
            }
                
            for(int i=1;i<=seatsOfDiamond;i++){
                m.diamondSeats.remove(0);
            }
            
            int priceOfTicketDiamond = seatsOfDiamond*150;
            
            m.availableDiamond -= seatsOfDiamond;
            
            Customer c1 = new Customer(nameOf,seatsOfDiamond,"Diamond",priceOfTicketDiamond,diamondAllot);
            customerList.add(c1);
            
            map.get(nameOf).add(c1);
                
                
                
            }else{
                System.out.println("Seats Of your Required Quantity Not Available !");
                System.out.println("----------------------");
                System.out.println("Showing Available Diamond");
                System.out.println("----------------------");
                
                for(String s:m.diamondSeats){
                    System.out.print(s+" ");
                }
                
                System.out.println();
                
                confirmBook("Diamond",nameOf);
            }
            
           
            
        }else if(userPref==2){
            if(m.availableGold <= 0){
                System.out.println("No Gold Seats Available");
                return;
            }
            
            List<String> goldAllot = new ArrayList<>();
            
            System.out.println("Enter No of Seats");
            int seatsOfGold = sc.nextInt();
            if(seatsOfGold<=m.availableGold){
                
                
            for(int i=1;i<=seatsOfGold;i++){
                goldAllot.add(m.goldSeats.get(i-1));
            }
                
            for(int i=1;i<=seatsOfGold;i++){
                m.goldSeats.remove(0);
            }
            
            m.availableGold -= seatsOfGold;
            
            int priceOfTicketGold = seatsOfGold*130;
            
            Customer c2 = new Customer(nameOf,seatsOfGold,"Gold",priceOfTicketGold,goldAllot);
            customerList.add(c2);
            
            map.get(nameOf).add(c2);
            
                
                
                
            }else{
                System.out.println("Seats Of your Required Quantity Not Available !");
                System.out.println("----------------------");
                System.out.println("Showing Available Gold");
                System.out.println("----------------------");
                
                for(String s:m.goldSeats){
                    System.out.print(s+" ");
                }
                
                System.out.println();
                
                confirmBook("Gold",nameOf);
                
            }
            
            
        }
        
        }else{
            System.out.println("No Tickets Availble Right Now !");
            return;
        }
    }
    
	public static void main(String[] args) {
	    boolean isTrue = true;
	    while(isTrue){
	        System.out.println("1-> Book Ticket");
	        System.out.println("2-> Print Ticket");
	        int choiceInit = sc.nextInt();
	        if(choiceInit==1){
	            book();
	        }else if(choiceInit==2){
	            print();
	        }else{
	            isTrue = false;
	        }
	    }
	}
}
