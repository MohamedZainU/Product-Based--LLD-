public class Flight{
    static int id = 0;
    int flightID;
    int seats;
    int price;
    
    public Flight(){
        id = id + 1;
        flightID = id;
        seats = 50;
        price = 5000;
    }
    
    public void show(){
        System.out.println("Flight ID: "+this.flightID);
        System.out.println("No Of Seats: "+this.seats);
        System.out.println("Price: "+this.price);
    }
    
    public void increment(int cusSeats){
        this.price = price + 200 * cusSeats;
        this.seats = seats - cusSeats;
    }
}