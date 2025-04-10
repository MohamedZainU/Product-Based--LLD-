public class Passenger{
    static int count = 0;
    int number;
    int id;
    String name;
    int age;
    String alloted;
    String berthName;
    
    public Passenger(String name,int age,String berthName){
        this.count = count + 1;
        this.id = count;
        this.name = name;
        this.age = age;
        this.berthName = berthName;
        alloted = "";
        number = -1;
    }
}