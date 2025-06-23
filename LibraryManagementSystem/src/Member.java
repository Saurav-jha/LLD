import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String memberId;
    private final String name;
    private final String email;
    private final String phone;
    private final List<IssueRecord> issuedBooks;

    public Member(String memberId, String name, String email, String phone){
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.issuedBooks = new ArrayList<>();
    }

    public String getMemberId(){
        return memberId;
    }

    public String getName(){
        return name;
    }

    public void addIssuedBooks(IssueRecord record){
        issuedBooks.add(record);
    }

    public List<IssueRecord> getIssuedBooks(){
        return issuedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", issuedBooks=" + issuedBooks +
                '}';
    }
}
