package service;

import model.Lending;
import node.LendingNode;
import node.BookNode;
import util.ValidateHandler;
import node.ReaderNode;

import java.util.Scanner;

public class LendingList {

    LendingNode head, tail;
    Scanner sc = new Scanner(System.in);
    BookList bookList;
    ReaderList readerList;

    public LendingList(BookList bookList, ReaderList readerList) {
        head = tail = null;
        this.bookList = bookList;
        this.readerList = readerList;
    }

    // 3.1 Input data
    public void addLending() {
        String bcode = ValidateHandler.getString("Enter book code: ");
        String rcode = ValidateHandler.getString("Enter read code: ");
        int state = ValidateHandler.getInt("Enter state (0,1,2): ", 0, 2);

        BookNode bookNode = bookList.search(bcode);
        ReaderNode readerNode = readerList.search(rcode);

        if (bookNode == null || readerNode == null) {
            System.out.println("Either book or reader not found. Lending not accepted.");
            return;
        }

        // Check duplication when state = 1
        if (state == 1 && search(bcode, rcode) != null) {
            System.out.println("Duplicated lending with state=1. Not accepted.");
            return;
        }

        if (bookNode.info.getLended() >= bookNode.info.getQuantity()) {
            state = 0;
            System.out.println("No more book available. Added with state=0.");
        } else {
            if (state == 1) {
                bookNode.info.setLended(bookNode.info.getLended() + 1);
            }
        }

        addLast(new Lending(bcode, rcode, state));
    }

    public void addLast(Lending lending) {
        LendingNode newNode = new LendingNode(lending);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public LendingNode search(String bcode, String rcode) {
        for (LendingNode p = head; p != null; p = p.next) {
            if (p.info.getBcode().equalsIgnoreCase(bcode)
                    && p.info.getRcode().equalsIgnoreCase(rcode)
                    && p.info.getState() == 1) {
                return p;
            }
        }
        return null;
    }

    // 3.2 Display data
    public void display() {
        if (head == null) {
            System.out.println("Lending list is empty.");
            return;
        }
        System.out.println("Bcode | Rcode | State");
        System.out.println("---------------------");
        for (LendingNode p = head; p != null; p = p.next) {
            System.out.println(p.info);
        }
    }

    // 3.3 Sort by bcode + rcode
    public void sortByBcodeRcode() {
        for (LendingNode i = head; i != null; i = i.next) {
            for (LendingNode j = i.next; j != null; j = j.next) {
                if (compare(i.info, j.info) > 0) {
                    Lending temp = i.info;
                    i.info = j.info;
                    j.info = temp;
                }
            }
        }
        System.out.println("Sorted lending list by bcode + rcode.");
    }

    private int compare(Lending l1, Lending l2) {
        int cmp = l1.getBcode().compareTo(l2.getBcode());
        if (cmp != 0) {
            return cmp;
        }
        return l1.getRcode().compareTo(l2.getRcode());
    }
}
