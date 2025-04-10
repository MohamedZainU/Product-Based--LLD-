import java.util.*;
class Library {
    private List<Book> books;
    private Map<String, User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void borrowBook(String username, String title,int quant) {
        User user = users.get(username);
        if (user != null) {
            Book book = findBookByTitle(title,quant);
            if (book != null) {
                user.borrowBook(book);
            } else {
                System.out.println("Book not found: " + title);
            }
        } else {
            System.out.println("User not found: " + username);
        }
    }

    public void returnBook(String username, String title,int quantR) {
        User user = users.get(username);
        if (user != null) {
            Book book = findBookByTitle(title,quantR);
            if (book != null) {
                user.returnBook(book);
            } else {
                System.out.println("Book not found: " + title);
            }
        } else {
            System.out.println("User not found: " + username);
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchBooks(String query) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                matchingBooks.add(book);
            }
        }

        if (matchingBooks.isEmpty()) {
            System.out.println("No books matching the search query: " + query);
        } else {
            System.out.println("Matching books:");
            for (Book book : matchingBooks) {
                System.out.println(book);
            }
        }
    }

    public void addUser(String username) {
        users.put(username, new User(username));
        System.out.println("User added: " + username);
    }

    public Book findBookByTitle(String title,int quant) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && quant<=book.quantity) {
                return book;
            }
        }
        
        return null;
    }
}