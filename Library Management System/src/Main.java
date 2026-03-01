import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        LibraryMember memberA = null;
        LibraryMember memberB = new LibraryMember("Alice Smith", 101);
        LibraryMember memberC = new LibraryMember("Bob Johnson", 102);

        LibraryItem item1 = null;
        LibraryItem item2 = new LibraryItem("Java Programming Basics", 501);
        LibraryItem item3 = new LibraryItem("Effective C++", 502);
        LibraryItem item4 = new LibraryItem("Data Structures Book", 503);
        LibraryItem item5 = new LibraryItem("Algorithm Design", 504);
        LibraryItem item6 = new LibraryItem("Web Dev Handbook", 505);
        LibraryItem item7 = new LibraryItem("Testing Methods", 506);

        try {
            memberA = new LibraryMember("", 100);
            System.out.println("Error: Member created successfully with invalid name (this should not be seen).");
        } catch (InvalidMemberNameException e) {
            System.err.println("Caught Runtime Exception: " + e.getMessage() + " (InvalidMemberNameException success.)");
        }

        try {
            item1 = new LibraryItem(null, 500);
            System.out.println("Error: Item created successfully with invalid title (this should not be seen).");
        } catch (InvalidItemTitleException e) {
            System.err.println("Caught Runtime Exception: " + e.getMessage() + " (InvalidItemTitleException success.)");
        }
        
        try {
            library.registerMember(memberB);
            library.registerMember(memberC);
            library.addNewItem(item2);
            library.addNewItem(item3);
            library.addNewItem(item4);
            library.addNewItem(item5);
            library.addNewItem(item6);

            System.out.println("All members and items registered successfully.");
        } catch (DuplicateMemberException | DuplicateItemException e) {
            System.err.println("Unexpected Checked Exception during registration: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to register Member B again...");
            LibraryMember memberB_duplicate = new LibraryMember("Alice Smith", 101);
            library.registerMember(memberB_duplicate);
            System.out.println("Error: Duplicate Member successfully registered (this should not be seen).");
        } catch (DuplicateMemberException e) {
            System.err.println("Caught Checked Exception: " + e.getMessage() + " (DuplicateMemberException success.)");
        }

        try {
            System.out.println("Attempting to add Item 2 again...");
            LibraryItem item2_duplicate = new LibraryItem("Java Reloaded", 501);
            library.addNewItem(item2_duplicate);
            System.out.println("Error: Duplicate Item successfully added (this should not be seen).");
        } catch (DuplicateItemException e) {
            System.err.println("Caught Checked Exception: " + e.getMessage() + " (DuplicateItemException success.)");
        }

        try {
            System.out.println("Attempting to borrow item with Invalid Member ID (999)...");
            library.borrowItem(999, 502);
            System.out.println("Error: Invalid User borrowed item (this should not be seen).");
        } catch (UserNotFoundException e) {
            System.err.println("Caught Checked Exception: " + e.getMessage() + " (UserNotFoundException success.)");
        } catch (ItemNotFoundException e) {
            System.err.println("Error: Unexpected ItemNotFoundException caught.");
        } catch (OverLimitException e) {
            System.err.println("Error: Unexpected OverLimitException caught.");
        }

        try {
            System.out.println("Attempting to borrow item with Invalid Item ID (900)...");
            library.borrowItem(101, 900);
            System.out.println("Error: Invalid Item borrowed (this should not be seen).");
        } catch (ItemNotFoundException e) {
            System.err.println("Caught Checked Exception: " + e.getMessage() + " (ItemNotFoundException success.)");
        } catch (UserNotFoundException e) {
            System.err.println("Error: Unexpected UserNotFoundException caught.");
        } catch (OverLimitException e) {
            System.err.println("Error: Unexpected OverLimitException caught.");
        }

        try {
            System.out.println("Borrowing items for Member B (ID: 101) to reach the limit of 5:");

            LibraryMember currentMember = library.findMemberById(101);
            if(currentMember != null) {
                library.borrowItem(101, 501);
                currentMember.setBorrowedCount(currentMember.getBorrowedCount() + 1);
                library.borrowItem(101, 502);
                currentMember.setBorrowedCount(currentMember.getBorrowedCount() + 1);
                library.borrowItem(101, 503);
                currentMember.setBorrowedCount(currentMember.getBorrowedCount() + 1);
                library.borrowItem(101, 504);
                currentMember.setBorrowedCount(currentMember.getBorrowedCount() + 1);
                library.borrowItem(101, 505);
                currentMember.setBorrowedCount(currentMember.getBorrowedCount() + 1);
            }

            System.out.println("Current Borrow Count: " + library.findMemberById(101).getBorrowedCount());

            System.out.println("Attempting to borrow the 6th item (OverLimitException should be thrown)...");
            library.addNewItem(item7);
            library.borrowItem(101, 506);

            System.out.println("Error: Member exceeded limit but borrowed item (this should not be seen).");
        } catch (OverLimitException e) {
            System.err.println("Caught Runtime Exception: " + e.getMessage() + " (OverLimitException success.)");
        } catch (Exception e) {
            System.err.println("Unexpected Checked Exception during limit test: " + e.getMessage());
        }

        try {
            System.out.println("Member B (ID: 101) is returning Item 501.");
            library.returnItem(101, 501);
            System.out.println("Return successful.");

            System.out.println("New Borrow Count: " + library.findMemberById(101).getBorrowedCount());
        } catch (Exception e) {
            System.err.println("Unexpected error during return: " + e.getMessage());
        }

        library.printAllMembers();
        library.printAllItems();
    }
}
