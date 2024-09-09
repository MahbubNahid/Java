public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        library.addBook(book1);
        library.addBook(book2);

        // List all books
        System.out.println("\nList of books in the library:");
        library.listBooks();

        // Borrow a book
        System.out.println("\nBorrowing 'The Great Gatsby':");
        library.borrowBook("9780743273565");

        // List all books again
        System.out.println("\nList of books after borrowing:");
        library.listBooks();

        // Return a book
        System.out.println("\nReturning 'The Great Gatsby':");
        library.returnBook("9780743273565");

        // List all books again
        System.out.println("\nList of books after returning:");
        library.listBooks();
    }
}
