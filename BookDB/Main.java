import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDirectory
{
    public static void insertData(Connection con,Book b) throws SQLException{
        PreparedStatement ps = con.prepareStatement("insert into Books(bookID,bookName,bookReleaseDate,bookAuthor) values(?,?,?,?)");
        ps.setInt(1,b.bookID);
        ps.setString(2,b.bookName);
        ps.setString(3,b.bookReleaseDate);
        ps.setInt(4,b.bookAuthor);
        ps.executeUpdate();
    }
    
    public static void searchBookByName(Connection con,String bookNameToSearch)throws SQLException{
        PreparedStatement ps = con.prepareStatement("select b.bookID,b.bookName,b.bookRelease,b.bookAuthor,a.authorName from Books b join Author a on b.bookAuthor = a.authorID where b.bookName LIKE ?;");
        ps.setString(1,bookNameToSearch);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("------------------------");
            System.out.println(rs.getString("bookID"));
            System.out.println(rs.getString("bookName"));
            System.out.println(rs.getString("bookReleaseDate"));
            System.out.println(rs.getInt("bookAuthor"));
            System.out.println(rs.getString("authorName"));
            System.out.println("------------------------");
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
		    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookDB","root","root");
            boolean isTrue = true;
            while(isTrue){
        System.out.println("1-> Insert Data");
		System.out.println("2-> Search By Year");
        System.out.println("3-> Exit");
		int choice = sc.nextInt();
		if(choice==1){
		System.out.println("Enter Book ID");
		int bookID = sc.nextInt();
		System.out.println("Enter Book Name");
		String bookName = sc.next();
		System.out.println("Enter Book Release Date");
		String bookReleaseDate = sc.next();
		System.out.println("Enter Author ID");
		int bookAuthor = sc.nextInt();
		Book b = new Book(bookID,bookName,bookReleaseDate,bookAuthor);
            insertData(con,b);
		}
		else if(choice==2){
		    System.out.println("Enter the BookName to Search");
		    String bookNameToSearch = sc.next();
		    searchBookByName(con,bookNameToSearch);
		}else if(choice==3){
            isTrue = false;
        }
    }
    }catch(ClassNotFoundException c){
        System.out.println(c);
    }catch(SQLException s){
        System.out.println(s);
    }
	}
}