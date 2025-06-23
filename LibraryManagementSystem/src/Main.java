import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();
    private static Librarian librarian;

    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System");

        // Initialize librarian
        System.out.print("Enter your Librarian Email: ");
        String email = scanner.nextLine();
        String staffId = Util.generateId();
        librarian = new Librarian(staffId, email, library);
        librarian.addSelfToLibrary();

        while (true) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> viewAllBooks();
                case 6 -> viewMemberIssuedBooks();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View All Books");
        System.out.println("6. View Member's Issued Books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Total Copies: ");
        int copies = Integer.parseInt(scanner.nextLine());

        System.out.print("Category (FICTION, SCIENCE, etc.): ");
        BookCategory category = BookCategory.valueOf(scanner.nextLine().toUpperCase());

        // Author
        List<Author> authors = new ArrayList<>();
        System.out.print("Number of Authors: ");
        int authorCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < authorCount; i++) {
            System.out.print("Author " + (i + 1) + " Name: ");
            String name = scanner.nextLine();
            System.out.print("Author " + (i + 1) + " Biography: ");
            String bio = scanner.nextLine();
            authors.add(new Author(name, bio));
        }

        // Publisher
        System.out.print("Publisher Name: ");
        String pubName = scanner.nextLine();
        System.out.print("Publisher Address: ");
        String pubAddress = scanner.nextLine();
        System.out.print("Publisher Phone: ");
        String pubPhone = scanner.nextLine();
        Publisher publisher = new Publisher(Util.generateId(), pubName, pubAddress, pubPhone);

        Book book = new Book(Util.generateId(), title,category, authors, publisher, isbn, copies);
        librarian.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void addMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Member member = new Member(Util.generateId(), name, email, phone);
        librarian.addMember(member);
        System.out.println("Member added successfully.");
    }

    private static void issueBook() {
        viewAllBooks();
        System.out.print("Enter Book ID to issue: ");
        String bookId = scanner.nextLine();

        listAllMembers();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();

        try {
            String issueId = librarian.issueBook(bookId, memberId);
            System.out.println("Book issued. Issue ID: " + issueId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter Issue ID to return: ");
        String issueId = scanner.nextLine();
        boolean success = librarian.returnBook(issueId);
        if (success) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Could not return. Invalid Issue ID or already returned.");
        }
    }

    private static void viewAllBooks() {
        System.out.println("--- All Books ---");
        for (Book book : librarian.getAllBooks()) {
            System.out.println(book);
        }
    }

    private static void listAllMembers() {
        System.out.println("--- Members ---");
        for (Member member : librarian.getAllMembers()) {
            System.out.println(member.getMemberId() + " - " + member.getName());
        }
    }

    private static void viewMemberIssuedBooks() {
        listAllMembers();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        Member member = librarian.getMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        System.out.println("--- Issued Books for " + member.getName() + " ---");
        for (IssueRecord record : member.getIssuedBooks()) {
            System.out.println(record);
        }
    }
}