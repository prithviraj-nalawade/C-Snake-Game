import java.util.*;

// Book class to represent each book in the library
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // Default status: book is available
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: \"" + title + "\", Author: " + author + ", Available: " + isAvailable;
    }
}

// User class to represent library users
class User {
    private int userId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}

// Library class to handle library operations
class Library {
    private ArrayList<Book> bookList;
    private ArrayList<User> userList;

    public Library() {
        bookList = new ArrayList<>();
        userList = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    // Register a new user to the library
    public void registerUser(User user) {
        userList.add(user);
        System.out.println("User registered successfully!");
    }

    // View all books in the library
    public void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("List of Books in the Library:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    // Borrow a book from the library
    public void borrowBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        if (user == null) {
            System.out.println("User not found!");
        } else if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isAvailable()) {
            System.out.println("Sorry, this book is currently not available.");
        } else {
            user.borrowBook(book);
            book.setAvailable(false);
            System.out.println(user.getName() + " borrowed the book: " + book.getTitle());
        }
    }

    // Return a borrowed book to the library
    public void returnBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        if (user == null) {
            System.out.println("User not found!");
        } else if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isAvailable()) {
            System.out.println("This book was not borrowed.");
        } else {
            user.returnBook(book);
            book.setAvailable(true);
            System.out.println(user.getName() + " returned the book: " + book.getTitle());
        }
    }

    // Search for a book by its title
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    // Helper method to find a user by their ID
    private User findUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    // Helper method to find a book by its ID
    private Book findBookById(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

// Main class to run the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book(101, "Java Programming", "James Gosling"));
        library.addBook(new Book(102, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(103, "Data Structures in Java", "Robert Lafore"));
        library.registerUser(new User(1, "Alice"));
        library.registerUser(new User(2, "Bob"));

        // Main menu
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. View All Books");
            System.out.println("4. Search for a Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.registerUser(new User(userId, name));
                    break;

                case 3:
                    library.viewAllBooks();
                    break;

                case 4:
                    System.out.print("Enter Book Title to Search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int borrowUserId = sc.nextInt();
                    System.out.print("Enter Book ID to Borrow: ");
                    int borrowBookId = sc.nextInt();
                    library.borrowBook(borrowUserId, borrowBookId);
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();
                    System.out.print("Enter Book ID to Return: ");
                    int returnBookId = sc.nextInt();
                    library.returnBook(returnUserId, returnBookId);
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
