/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static List<Customer> customerList = new ArrayList<>();
    static int accNo = 33716;
    static List<Transaction> transactionList = new ArrayList<>();
    static HashMap<Integer,List<Transaction>> map = new HashMap<>();
    
    
    public static void transaction(Customer c){
        
        
        for(Map.Entry<Integer,List<Transaction>> res:map.entrySet()){
            int accNoToProcess = res.getKey();
            if(accNoToProcess==c.accNo){
                List<Transaction> tr = map.get(c.accNo);
                for(Transaction t:tr){
                    System.out.println("-------------------------------");
                    System.out.println("Name: "+t.nameOfCus);
                    System.out.println("Account No: "+t.accNo);
                    System.out.println("Deposit: "+t.depMoney);
                    System.out.println("WithDrawl: "+t.withdrawMoney);
                    System.out.println("Balance: "+t.totalBal);
                    System.out.println("--------------------------------");
                }
            }
        }
    }
    
    
    public static void withdraw(Customer c){
        boolean isIn = false;
        System.out.println("Enter Amount To WithDraw");
        int withdrawAmt = sc.nextInt();
        if(withdrawAmt>=c.totalBal){
            System.out.println("Amount Defined is higher than amount present");
            return;
        }else if(c.totalBal<=500){
            System.out.println("Atleat Min Balance Should be Maintained");
            return;
        }
        c.totalBal -= withdrawAmt;
        
        
        
        Transaction t = new Transaction();
        t.totalBal = c.totalBal;
        t.nameOfCus = c.CusName;
        t.accNo = c.accNo;
        t.withdrawMoney = withdrawAmt;
        t.depMoney = 0;
        c.list.add(t);
        map.put(c.accNo,c.list);
    }
    
    
    public static void deposit(Customer c){
        System.out.println("Enter Amount for Deposit");
        int depMoney = sc.nextInt();
        c.totalBal += depMoney;
        Transaction t = new Transaction();
        t.totalBal = c.totalBal;
        t.nameOfCus = c.CusName;
        t.accNo = c.accNo;
        t.depMoney = depMoney;
        t.withdrawMoney = 0;
        c.list.add(t);
        map.put(c.accNo,c.list);
    }
    
    
    public static void action(Customer c){
        System.out.println("--------------------------------");
        System.out.println("Your Account No: "+c.accNo);
        System.out.println("--------------------------------");
        System.out.println("1-> Deposit");
        System.out.println("2-> WithDraw");
        System.out.println("3-> View Transaction");
        int choiceAction = sc.nextInt();
        if(choiceAction==1){
            deposit(c);
        }else if(choiceAction==2){
            withdraw(c);
        }else if(choiceAction==3){
            transaction(c);
        }
    }
    
    
    public static void Login(){
        boolean isTrue = false;
        System.out.println("Enter Account Number");
        int accNoCheck = sc.nextInt();
        for(Customer c:customerList){
            if(c.accNo==accNoCheck){
                isTrue = true;
                action(c);
            }
        }
        
        if(!isTrue){
            System.out.println("No Account Number exists");
        }
    }
    
    public static void create(){
        System.out.println("Enter your Name");
        String CusName = sc.next();
        System.out.println("Enter your Age");
        int Cusage = sc.nextInt();
        
        if(Cusage<12){
            System.out.println("No Account can be created for Children");
            return;
        }
        
        Customer c = new Customer(CusName,Cusage,accNo);
        customerList.add(c);
        accNo *= 2;
        action(c);
    }
    
	public static void main(String[] args) {
		boolean isTrue = true;
		
		while(isTrue){
		    System.out.println("1-> Create Account");
		    System.out.println("2-> Login To Account");
		    int choiceInit = sc.nextInt();
		    if(choiceInit==1){
		        create();
		    }else if(choiceInit==2){
		        Login();
		    }else{
		        isTrue = false;
		    }
		}
	}
}
