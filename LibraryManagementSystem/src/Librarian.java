import java.util.List;

public class Librarian{
    private final String staffId;
    private final String email;
    private final Library library;

    public Librarian(String staffId, String email, Library library){
        this.staffId = staffId;
        this.email = email;
        this.library = library;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void addMember(Member member) {
        library.addMember(member);
    }

    public String issueBook(String bookId, String memberId) {
        return library.issueBook(bookId, memberId);
    }

    public boolean returnBook(String issueId) {
        return library.returnBook(issueId);
    }

    public List<Book> getAllBooks() {
        return library.getBooks();
    }

    public List<Member> getAllMembers() {
        return library.getMembers();
    }

    public Member getMemberById(String memberId) {
        return library.findMemberById(memberId);
    }

    public void addSelfToLibrary() {
        library.addLibrarian(this);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
