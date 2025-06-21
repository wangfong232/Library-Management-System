package console;

import util.ValidateHandler;
import service.BookList;
import service.ReaderList;
import service.LendingList;

public class Main {

    public static void main(String[] args) {
        BookList bookList = new BookList();
        ReaderList readerList = new ReaderList();
        LendingList lendingList = new LendingList(bookList, readerList);

        while (true) {
            System.out.println("\n============LIBRARY MENU=============");
            System.out.println("1. Book list");
            System.out.println("2. Reader list");
            System.out.println("3. Lending list");
            System.out.println("0. Exit");
            int mainChoice = ValidateHandler.getInt("Enter your choice: ", 0, 3);

            if (mainChoice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            switch (mainChoice) {
                case 1:
                    bookMenu(bookList);
                    break;
                case 2:
                    readerMenu(readerList);
                    break;
                case 3:
                    lendingMenu(lendingList);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Submenu for Book
    private static void bookMenu(BookList bookList) {
        while (true) {
            System.out.println("\nBOOK MENU");
            System.out.println("1. Load book data from file");
            System.out.println("2. Add new book");
            System.out.println("3. Display all books");
            System.out.println("4. Save books to file");
            System.out.println("5. Search book code");
            System.out.println("6. Delete book by code");
            System.out.println("7. Sort book list by code");
            System.out.println("8. Add book to beginning");
            System.out.println("9. Add book after position k");
            System.out.println("10. Delete book at position k");
            System.out.println("0. Back to main menu");
            int choice = ValidateHandler.getInt("Enter your choice: ", 0, 10);

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    String file = ValidateHandler.getString("Enter file name: ");
                    bookList.loadFromFile(file);
                    break;
                case 2:
                    bookList.addBook();
                    break;
                case 3:
                    bookList.display();
                    break;
                case 4:
                    String saveFile = ValidateHandler.getString("Enter file name to save: ");
                    bookList.saveToFile(saveFile);
                    break;
                case 5:
                    bookList.searchBook();
                    break;
                case 6:
                    bookList.deleteByBcode();
                    break;
                case 7:
                    bookList.sortByBcode();
                    break;
                case 8:
                    bookList.addBookFirst();
                    break;
                case 9:
                    bookList.addAfterPosition();
                    break;
                case 10:
                    bookList.deleteAtPosition();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Submenu for Reader
    private static void readerMenu(ReaderList readerList) {
        while (true) {
            System.out.println("\nREADER MENU");
            System.out.println("1. Load reader data from file");
            System.out.println("2. Add new reader");
            System.out.println("3. Display all readers");
            System.out.println("4. Save readers to file");
            System.out.println("5. Search reader code");
            System.out.println("6. Delete reader by code");
            System.out.println("0. Back to main menu");
            int choice = ValidateHandler.getInt("Enter your choice: ", 0, 6);

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    String file = ValidateHandler.getString("Enter file name: ");
                    readerList.loadDataFromFile(file);
                    break;
                case 2:
                    readerList.addReader();
                    break;
                case 3:
                    readerList.display();
                    break;
                case 4:
                    String saveFile = ValidateHandler.getString("Enter file name to save: ");
                    readerList.saveToFile(saveFile);
                    break;
                case 5:
                    readerList.searchReader();
                    break;
                case 6:
                    readerList.deleteByRcode();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Submenu for Lending
    private static void lendingMenu(LendingList lendingList) {
        while (true) {
            System.out.println("\nLENDING MENU");
            System.out.println("1. Input lending");
            System.out.println("2. Display lending list");
            System.out.println("3. Sort lending list by bcode + rcode");
            System.out.println("0. Back to main menu");
            int choice = ValidateHandler.getInt("Enter your choice: ", 0, 3);

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    lendingList.addLending();
                    break;
                case 2:
                    lendingList.display();
                    break;
                case 3:
                    lendingList.sortByBcodeRcode();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
