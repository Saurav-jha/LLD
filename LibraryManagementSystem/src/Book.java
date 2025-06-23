import java.util.List;

public class Book {

    private final String bookId;
    private final String title;
    private final BookCategory category;
    private final List<Author> authors;
    private final Publisher publisher;
    private final String isbn;
    private int totalCopies;
    private int availableCopies;

    public Book(String bookId, String title,BookCategory category, List<Author> authors,
                Publisher publisher, String isbn, int totalCopies){
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public BookCategory getCategory(){
        return category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void increaseAvailableCopies(){
        if(availableCopies < totalCopies){
            availableCopies++;
        }
    }

    public void decreaseAvailableCopies(){
        if(availableCopies > 0){
            availableCopies--;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", authors=" + authors +
                ", publisher=" + publisher +
                ", isbn='" + isbn + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
