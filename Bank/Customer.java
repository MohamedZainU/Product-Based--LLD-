import java.util.*;
public class Customer{
    String CusName;
    int Cusage;
    int accNo;
    int totalBal;
    List<Transaction> list;
    
    public Customer(String CusName,int Cusage,int accNo){
        this.CusName = CusName;
        this.Cusage = Cusage;
        this.accNo = accNo;
        this.totalBal = 2000;
        this.list = new ArrayList<>();
    }
}