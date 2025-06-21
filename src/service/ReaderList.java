package service;

import model.Reader;
import node.ReaderNode;
import util.ValidateHandler;
import java.io.*;

public class ReaderList {

    ReaderNode head, tail;

    public ReaderList() {
        head = tail = null;
    }

    // 2.1 Load data from file
    public void loadDataFromFile(String filename) {
        File file = new File(filename);
        System.out.println("Full absolute path: " + file.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String rcode = parts[0].trim();
                String name = parts[1].trim();
                int byear = Integer.parseInt(parts[2].trim());
                if (byear < 1900 || byear > 2010) {
                    continue;
                }
                addLast(new Reader(rcode, name, byear));
            }
            System.out.println("Load file successfully!");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 2.2 Input & add to end
    public void addReader() {
        String rcode = ValidateHandler.getString("Rcode: ");
        if (search(rcode) != null) {
            System.out.println("Duplicated rcode. Not added.");
            return;
        }
        String name = ValidateHandler.getString("Name: ");
        int byear = ValidateHandler.getInt("Birth year (1900-2010): ", 1900, 2010);
        addLast(new Reader(rcode, name, byear));
    }

    public void addLast(Reader reader) {
        ReaderNode newNode = new ReaderNode(reader);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 2.3 Display
    public void display() {
        if (head == null) {
            System.out.println("Reader list is empty.");
            return;
        }
        System.out.println("Rcode | Name       | Byear");
        System.out.println("-----------------------------");
        for (ReaderNode p = head; p != null; p = p.next) {
            System.out.println(p.info);
        }
    }

    // 2.4 Save to file
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (ReaderNode p = head; p != null; p = p.next) {
                pw.printf("%s | %s | %d\n", p.info.getRcode(), p.info.getName(), p.info.getByear());
            }
            System.out.println("Save successfully to file.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // 2.5 Search
    public ReaderNode search(String rcode) {
        for (ReaderNode p = head; p != null; p = p.next) {
            if (p.info.getRcode().equalsIgnoreCase(rcode)) {
                return p;
            }
        }
        return null;
    }

    public void searchReader() {
        String rcode = ValidateHandler.getString("Enter rcode: ");
        ReaderNode result = search(rcode);
        if (result != null) {
            System.out.println(result.info);
        } else {
            System.out.println("Not found.");
        }
    }

    // 2.6 Delete
    public void deleteByRcode() {
        String rcode = ValidateHandler.getString("Enter rcode to delete: ");
        if (head == null) {
            return;
        }
        if (head.info.getRcode().equalsIgnoreCase(rcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Deleted.");
            return;
        }
        ReaderNode prev = head;
        ReaderNode curr = head.next;
        while (curr != null) {
            if (curr.info.getRcode().equalsIgnoreCase(rcode)) {
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
}
