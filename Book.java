public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // Methods
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("The book '" + title + "' has been borrowed.");
        } else {
            System.out.println("The book '" + title + "' is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("The book '" + title + "' has been returned.");
        } else {
            System.out.println("The book '" + title + "' was not borrowed.");
        }
    }

    public String getBookInfo() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Status: " + status;
    }

    public String getIsbn() {
        return isbn;
    }
}
