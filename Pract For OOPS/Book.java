import java.util.*;
class Book {
    private String title;
    private String author;
    private String isbn;
    public int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // Getters and setters for book attributes

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Quantity: " + quantity;
    }

    public String getTitle() {
        return title;
    }
    
    
    public String getAuthor(){
        return author;
    }
    
    
    public void decrementQuantity() {
        quantity--;
    }

    public void incrementQuantity() {
        quantity++;
    }
}
