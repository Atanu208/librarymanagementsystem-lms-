package librarymanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String,Book> books;
    private Map<String,User> users;

    public Library() {
        this.books = new HashMap<>();
        this.users=new HashMap<>();
    }

    public void addBook(Book book)
    {
        books.put(book.getIsbn(), book);
    }

    public void registerUser(User user)
    {
        users.put(user.getId(), user);
    }
    
    public void borrowBook(String userId,String isbn)
    {
        Book book=books.get(isbn);
        User user=users.get(userId);

        if(book==null) 
        {
            System.out.println("Book not found.");
            return;
        }
        if(user==null)
        {
            System.out.println("User not found.");
            return;
        }
        if(book.isIssued())
        {
            System.out.println("Book already issued.");
            return;
        }
        if(!user.canBorrowMore())
        {
            System.out.println("User has alredy borrowed max 2 books.");
            return;
        }
        book.setIssued(true);
        user.borrowBook(book);
        System.out.println("Book issued successfully to user Id"+userId);
    }

    public void returnBook(String userId,String isbn)
    {
        Book book=books.get(isbn);
        User user=users.get(userId);

        if(book==null)
        {
            System.out.println("Invalid book isbn");
            return;
        }
        if(user==null)
        {
            System.out.println("Invalid user id");
            return;
        }
        if(!user.getBorrowedBooks().contains(book))
        {
            System.out.println("User didn't borrow this book");
            return;
        }

        user.returnBook(book);
        book.setIssued(false);
        System.out.println("Book returned successfully.!");
    }
    public void showAvailableBooks()
    {
        System.out.println("Available Books:");
        for(Book book:books.values())
        {
            if(!book.isIssued())
            {
                System.out.println(book);
            }
        }
    }

    public void showUserBooks(String userId)
    {
        User user=users.get(userId);
        if(user==null)
        {
            System.out.println("User not found");
            return;
        }
        System.out.println("Books borrowed by "+userId+":");
        for(Book book:user.getBorrowedBooks())
        {
            System.out.println(book);
        }
    }
}
