package service;

import node.BookNode;
import util.ValidateHandler;
import java.io.*;
import model.Book;

public class BookList {

    private BookNode head, tail;

    public BookList() {
        head = tail = null;
    }

    // 1.1 Load data from file
    public void loadFromFile(String filename) {
        File file = new File(filename);
        System.out.println("Full absolute path: "+ file.getAbsolutePath());
        int lineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length != 4) {
                    System.out.println("Line" + lineNumber + ": Invalid format (excepted 4 fields): " + line);
                    continue;
                }
                String bcode = parts[0].trim();
                String title = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());
                Book book = new Book(bcode, title, quantity, 0, price);
                addLast(book);
            }
            System.out.println("Load file successfully!");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 1.2 Input & add to end
    public void addBook() {
        String bcode = ValidateHandler.getString("Bcode: ");
        if (search(bcode) != null) {
            System.out.println("Duplicated bcode. Not added.");
            return;
        }
        String title = ValidateHandler.getString("Title: ");
        int quantity = ValidateHandler.getInt("Quantity: ", 0, Integer.MAX_VALUE);
        double price = ValidateHandler.getDouble("Price: ", 0, Double.MAX_VALUE);
        Book book = new Book(bcode, title, quantity, 0, price);
        addLast(book);
    }

    public void addLast(Book book) {
        BookNode newNode = new BookNode(book);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 1.3 Display data
    public void display() {
        if (head == null) {
            System.out.println("Book list is empty.");
            return;
        }
        System.out.println("Bcode | Title                          |  Qty  | Lend  |  Price  |  Value");
        System.out.println("--------------------------------------------------------------------------");
        for (BookNode p = head; p != null; p = p.next) {
            System.out.println(p.info);
        }
    }

    // 1.4 Save to file
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (BookNode p = head; p != null; p = p.next) {
                pw.printf("%s | %s | %d | %.1f\n",
                        p.info.getBcode(), p.info.getTitle(),
                        p.info.getQuantity(), p.info.getPrice());
            }
            System.out.println("Save successfully to file.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // 1.5 Search by bcode
    public BookNode search(String bcode) {
        for (BookNode p = head; p != null; p = p.next) {
            if (p.info.getBcode().equalsIgnoreCase(bcode)) {
                return p;
            }
        }
        return null;
    }

    public void searchBook() {
        String bcode = ValidateHandler.getString("Enter bcode: ");
        BookNode result = search(bcode);
        if (result != null) {
            System.out.println(result.info);
        } else {
            System.out.println("Not found.");
        }
    }

    // 1.6 Delete by bcode
    public void deleteByBcode() {
        String bcode = ValidateHandler.getString("Enter bcode to delete : ");
        if (head == null) {
            return;
        }
        // Delete head
        if (head.info.getBcode().equalsIgnoreCase(bcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Deleted.");
            return;
        }
        // Delete other nodes
        BookNode prev = head;
        BookNode curr = head.next;
        while (curr != null) {
            if (curr.info.getBcode().equalsIgnoreCase(bcode)) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                System.out.println("Deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Not found.");
    }

    // 1.7 Sort by bcode
    public void sortByBcode() {
        if (head == null || head.next == null) {
            System.out.println("List is empty or has only one element.");
            return;
        }
        for (BookNode i = head; i != null; i = i.next) {
            for (BookNode j = i.next; j != null; j = j.next) {
                if (i.info.getBcode().compareTo(j.info.getBcode()) > 0) {
                    Book temp = i.info;
                    i.info = j.info;
                    j.info = temp;
                }
            }
        }
        System.out.println("Sorted successfully.");
    }

    // 1.8 Input & add to beginning
    public void addFirst(Book book) {
        BookNode newNode = new BookNode(book);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addBookFirst() {
        String bcode = ValidateHandler.getString("Bcode: ");
        if (search(bcode) != null) {
            System.out.println("Duplicated bcode. Not added.");
            return;
        }
        String title = ValidateHandler.getString("Title: ");
        int quantity = ValidateHandler.getInt("Quantity: ", 0, Integer.MAX_VALUE);
        double price = ValidateHandler.getDouble("Price: ", 0, Double.MAX_VALUE);
        Book book = new Book(bcode, title, quantity, 0, price);
        addFirst(book);
    }

    // 1.9 Add after position k
    public void addAfterPosition() {
        int k = ValidateHandler.getInt("Enter position k : ", 0, Integer.MAX_VALUE);
        String bcode = ValidateHandler.getString("Bcode: ");
        if (search(bcode) != null) {
            System.out.println("Duplicated bcode. Not added.");
            return;
        }
        String title = ValidateHandler.getString("Title: ");
        int quantity = ValidateHandler.getInt("Quantity: ", 0, Integer.MAX_VALUE);
        double price = ValidateHandler.getDouble("Price: ", 0, Double.MAX_VALUE);
        BookNode newNode = new BookNode(new Book(bcode, title, quantity, 0, price));

        if (k == 0) {
            addFirst(newNode.info);
            return;
        }

        BookNode p = head;
        int count = 0;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }

        if (p == null) {
            System.out.println("Position out of bounds.");
        } else {
            newNode.next = p.next;
            p.next = newNode;
            if (p == tail) {
                tail = newNode;
            }
        }
    }

    // 1.10 Delete at position k
    public void deleteAtPosition() {
        if (head == null) {
            System.out.println("List empty.");
            return;
        }

        int k = ValidateHandler.getInt("Enter position k to delete: ", 0, Integer.MAX_VALUE);

        // Delete at position 0 (head)
        if (k == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        BookNode p = head;
        int position = 0;
        // Find position k-1
        while (p.next != null && position < k - 1) {
            p = p.next;
            position++;
        }
        if (p.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        p.next = p.next.next;
        if (p.next == null) {
            tail = p;
        }
        System.out.println("Book at position " + k + " deleted successfully.");
    }
}
