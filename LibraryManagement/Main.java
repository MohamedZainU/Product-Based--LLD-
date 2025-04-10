/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Book> bookList = new ArrayList<>();
    
    static ArrayList<String> bookBorrowed = new ArrayList<>();
    
    static int keepTrackBorrowed;
    
    static int borrowQuantity;
    
    static int borrow =0;
    
    static int keepTrackBookQuant;
    
    
    public static void search(){
        System.out.println("Enter Book Name to Search");
        String bookToFind = sc.next();
        boolean isFound1 = false;
        for(Book b:bookList){
            if(b.bookTitle.equals(bookToFind)){
                isFound1 = true;
                System.out.println("----------------------");
                System.out.println("Author "+b.authorName);
		        System.out.println("ISBN "+b.isbnNo);
		        System.out.println("Quantity "+b.bookQuantuty);
		        System.out.println("----------------------");
            }
        }
        if(!isFound1){
            System.out.println("No Book Available");
        }
    }
    
    
    public static void returnBook(int borrow){
        System.out.println("Enter Return Book Name");
        String bookReturn = sc.next();
        System.out.println("Enter Return Quantity");
        int bookRQuant = sc.nextInt();
        
        for(Book b:bookList){
            if(b.bookTitle.equals(bookReturn)){
                b.bookQuantuty += bookRQuant;
            }
        }
        
        int changed = borrowQuantity-bookRQuant;
        
        if(keepTrackBorrowed==bookRQuant){
            bookBorrowed.remove(borrow-1);
        }else{
            for(Book b:bookList){
                if(b.bookTitle.equals(bookReturn)){
            bookBorrowed.set(borrow-1, "Title "+b.bookTitle+" Author "+b.authorName+" ISBN "+b.isbnNo+" Quantity "+changed);
                }
            }
        }
    }
    
    
    public static void borrowBook(){
        System.out.println("Enter Book Name");
        String bookToSearch = sc.next();
        System.out.println("Enter Quantity Of Book");
        borrowQuantity = sc.nextInt();
        String borrowed = "";
        boolean isFound = false;
        
        
        for(Book b:bookList){
            if(b.bookTitle.equals(bookToSearch)){
                isFound = true;
                if(borrowQuantity<=b.bookQuantuty){
                    if(b.bookQuantuty==borrowQuantity){
                        keepTrackBorrowed = borrowQuantity;
                    }
                borrowed = "Title "+b.bookTitle+" Author "+b.authorName+" ISBN "+b.isbnNo+" Quantity "+borrowQuantity;
                b.bookQuantuty -= borrowQuantity;
                keepTrackBookQuant = b.bookQuantuty;
                }
            }
        }
        if(!isFound){
            System.out.println("No Book Available!");
        }
        bookBorrowed.add(borrowed);
    }
    
    
    public static void addBook(){
        System.out.println("Enter Title of Book");
        String bookTitle = sc.next();
        System.out.println("Enter Author Name");
        String authorName = sc.next();
        System.out.println("Enter ISBN Number");
        int isbnNo = sc.nextInt();
        System.out.println("Enter Quantity");
        int bookQuantuty = sc.nextInt();
        Book book = new Book(bookTitle,authorName,isbnNo,bookQuantuty);
        bookList.add(book);
    }
    
	public static void main(String[] args) {
		boolean isTrue = true;
		
		while(isTrue){
		    System.out.println("1-> Add a Book");
		    System.out.println("2-> Borrow a Book");
		    System.out.println("3-> Return a Book");
		    System.out.println("4-> List Books");
		    System.out.println("5-> Search Books");
		    System.out.println("6-> List Borrowed Books");
		    
		    int choiceOfInit = sc.nextInt();
		    
		    if(choiceOfInit==0){
		        isTrue = false;
		    }else if(choiceOfInit==1){
		        addBook();
		    }else if(choiceOfInit==2){
		        borrowBook();
		        borrow++;
		    }else if(choiceOfInit==3){
		        returnBook(borrow);
		    }else if(choiceOfInit==4){
		        if(keepTrackBookQuant>0){
		        for(Book b:bookList){
		            System.out.println("----------------------");
		            System.out.println("Title "+b.bookTitle);
		            System.out.println("Author "+b.authorName);
		            System.out.println("ISBN "+b.isbnNo);
		            System.out.println("Quantity "+b.bookQuantuty);
		            System.out.println("----------------------");
		        }
		        }else{
		            Iterator<Book> bookIT = bookList.iterator();
		            while(bookIT.hasNext()){
		                Book b = bookIT.next();
		                if(b.bookQuantuty<=0){
		                    bookIT.remove();
		                    System.out.println("No Books Available");
		                    return;
		                }
		            }
		        }
		    }else if(choiceOfInit==5){
		        search();
		    }else if(choiceOfInit==6){
		        for(String s:bookBorrowed){
		            System.out.println(s);
		        }
		    }
		    
		}
	}
}
