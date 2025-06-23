import java.util.Date;

public class IssueRecord {

    private final String issuedId;
    private final Book book;
    private final Member member;
    private final Date issuedDate;
    private Date returnDate;
    private final Date dueDate;
    private IssueStatus issueStatus;

    public IssueRecord(String issuedId, Book book, Member member, Date issuedDate,
                       Date dueDate){
        this.issuedId = issuedId;
        this.book = book;
        this.member = member;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
        this.issueStatus = IssueStatus.ISSUED;
    }

    public String getIssuedId() {
        return issuedId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMemberId() {
        return member;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public IssueStatus getStatus() {
        return issueStatus;
    }

    public void markReturned(Date returnDate){
        this.returnDate = returnDate;
        this.issueStatus = IssueStatus.RETURNED;
    }

    @Override
    public String toString() {
        return "IssueRecord{" +
                "issuedId='" + issuedId + '\'' +
                ", book=" + book +
                ", member=" + member +
                ", issuedDate=" + issuedDate +
                ", returnDate=" + returnDate +
                ", dueDate=" + dueDate +
                ", issueStatus=" + issueStatus +
                '}';
    }
}
