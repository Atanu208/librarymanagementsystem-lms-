package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrowMore()
    {
        return borrowedBooks.size()<2;
    }

    public void borrowBook(Book book)
    {
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book)
    {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + ", borrowedBooks=" + borrowedBooks.size() + "]";
    }
    
}
