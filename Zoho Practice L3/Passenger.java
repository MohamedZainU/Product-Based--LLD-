public class Passenger{
    static int id = 0;
    int passID;
    String passName;
    int agePass;
    String berthPass;
    int seatNo;
    
    public Passenger(String passName,int agePass,String berthPass){
        this.passName = passName;
        this.agePass = agePass;
        this.berthPass = berthPass;
        id = id + 1;
        passID = id;
    }
}