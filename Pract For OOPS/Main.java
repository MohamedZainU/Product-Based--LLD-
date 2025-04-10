/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. List Books");
            System.out.println("5. Search for a Book");
            System.out.println("6. Add User");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter quantity available: ");
                    int quantity = scanner.nextInt();
                    library.addBook(new Book(title, author, isbn, quantity));
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Enter book title to borrow: ");
                    String bookToBorrow = scanner.nextLine();
                    System.out.println("Enter Quantity");
                    int quant = scanner.nextInt();
                    if(quant>3){
                        System.out.println("User can't buy books more than 3");
                    }else{
                    library.borrowBook(borrowerName, bookToBorrow,quant);
                    }
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    String returnerName = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String bookToReturn = scanner.nextLine();
                    System.out.println("Enter Quantity");
                    int quantR = scanner.nextInt();
                    library.returnBook(returnerName, bookToReturn,quantR);
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    System.out.print("Enter search query (title or author): ");
                    String searchQuery = scanner.nextLine();
                    library.searchBooks(searchQuery);
                    break;
                case 6:
                    System.out.print("Enter username to add: ");
                    String newUser = scanner.nextLine();
                    library.addUser(newUser);
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
