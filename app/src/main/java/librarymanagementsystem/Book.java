package librarymanagementsystem;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isIssued() {
        return isIssued;
    }

    
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", isIssued=" + (isIssued ? "Issued" : "Available"+"]");
    }

    
}
