import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;
    private final List<Member> members;
    private final List<Librarian> librarians;
    private final List<IssueRecord> issueRecords;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.issueRecords = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String authorName) {
        return books.stream()
                .filter(b -> b.getAuthors().stream()
                        .anyMatch(a -> a.getName().toLowerCase().contains(authorName.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Book> searchByCategory(BookCategory category) {
        return books.stream()
                .filter(b -> b.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Book findBookById(String bookId) {
        return books.stream()
                .filter(b -> b.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    public void addMember(Member member){
        this.members.add(member);
    }

    public Member findMemberById(String memberId) {
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public String issueBook(String bookId, String memberId){
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null || member == null) {
            throw new IllegalArgumentException("Invalid book ID or member ID.");
        }

        if (book.getAvailableCopies() <= 0) {
            throw new IllegalStateException("No copies available.");
        }

        book.decreaseAvailableCopies();
        Date issueDate = Util.getCurrentDate();
        Date dueDate = Util.getDueDate(15);
        IssueRecord record = new IssueRecord(Util.generateId(),book, member, issueDate,dueDate);
        issueRecords.add(record);
        member.addIssuedBooks(record);
        return record.getIssuedId();
    }

    public boolean returnBook(String issueId) {
        for (IssueRecord record : issueRecords) {
            if (record.getIssuedId().equals(issueId) && record.getStatus() == IssueStatus.ISSUED) {
                record.markReturned(Util.getCurrentDate());
                record.getBook().increaseAvailableCopies();
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks(){
        return books;
    }

    public List<Member> getMembers(){
        return members;
    }

    public List<Librarian> getAllLibrarian(){
        return librarians;
    }

    public List<IssueRecord> getAllIssuedRecord(){
        return issueRecords;
    }
}
