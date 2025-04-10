import java.util.*;
class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters for user attributes

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 3) {
            borrowedBooks.add(book);
            book.decrementQuantity();
            System.out.println(name + " has borrowed " + book.getTitle());
        } else {
            System.out.println(name + " has reached the maximum limit of borrowed books (3).");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.incrementQuantity();
            System.out.println(name + " has returned " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow " + book.getTitle());
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}