# 📚 Library Management System

> A **console-based Library Management System** implemented in Java using **custom Linked Lists** for data storage and management.  
> Fully satisfies requirements of **DSA Assignment 1.1 — Linked List Project**.

---

## 🔖 Features

### 📘 Book Management

- Load book data from file
- Add new books (at end, beginning, or after position k)
- Display all books (with quantity, lended, price, and total value)
- Save books to file
- Search books by code
- Delete books by code or by position
- Sort books alphabetically by code

### 👤 Reader Management

- Load reader data from file (with birth year validation 1900-2010)
- Add new readers (duplicate code checking)
- Display readers
- Save readers to file
- Search readers by code
- Delete readers by code

### 🔄 Lending Management

- Add lending record with automatic validation
- Display lending list
- Sort lending list by Book Code + Reader Code
- Automatically track book availability (lended vs quantity)
- Manage lending states:
  - `0`: Book not given to reader
  - `1`: Book with reader
  - `2`: Book returned to library

### 🔑 Input Validation

- Integer input with range checking
- Double input with range checking
- Non-empty string input validation
- Auto-retry on invalid user input

---

## 📁 Project Structure

```bash
.
├── console/        # Menu interface (Main.java)
├── model/          # Data models (Book, Reader, Lending)
├── node/           # Linked List Node classes
├── service/        # Business logic for BookList, ReaderList, LendingList
├── util/           # Input validation helper (ValidateHandler.java)
├── bookIn          # Sample book input data file
├── readerIn        # Sample reader input data file
└── run.bat         # Batch file to compile & run entire project
```
---
![image](https://github.com/user-attachments/assets/c26826de-6467-4165-b15b-3afa6daa0675)
![image](https://github.com/user-attachments/assets/a2bfbb30-9926-4917-b665-bffa6576def2)
![image](https://github.com/user-attachments/assets/965c77ef-09d8-4dbd-8c99-6809de3aee9c)
<hr>
## 💾 Data Format

### 📚 `bookIn` file format

Format: 
<br>BookCode | Title | Quantity | Price

Example:<br>
B03 | Morning | 12 | 25.1<br>
B01 | The noon | 10 | 5.2<br>
B02 | River | 5 | 4.3

### 👤 `readerIn` file format

Format:
<br>ReaderCode | Name | BirthYear<br>
Example:<br>
R03 | Hoa | 1902<br>
R01 | La | 1901<br>


---

## ⚙ How to Run

### 🔸 Method 1: Using `run.bat` (Windows - recommended)

1. Make sure your directory structure is correct (as above).
2. Simply double-click `run.bat` file.

Batch file content:

```batch
cls
javac model\*.java node\*.java service\*.java util\*.java console\*.java
java console.Main
pause
del model\*.class node\*.class service\*.class util\*.class console\*.class
```
### 🔸 Method 2: Manual Compilation (Any OS)
```batch
javac model/*.java node/*.java service/*.java util/*.java console/*.java
java console.Main
```
### 🔸 Method 3: Using NetBeans (or any IDE)
- Open project
- Build & Run directly

---
### 🧪 Sample Data
Included:
- bookIn: Sample book data
- readerIn: Sample reader data
You can edit or expand data for your own testing.

## 🛠️ Technical Details
- Language: Java 8+
- Data Structure: Singly Linked Lists
- File I/O: Text file (pipe-separated values)
- Validation: Strong user input checking
- Console-based: User-friendly menu-driven interface

## 🎯 Educational Purpose
- This project is built for academic practice purposes to demonstrate:
- Object-Oriented Programming (OOP) in Java
- Custom linked list implementation
- File handling with text files
- Error handling and user interaction
- Modularity and separation of concerns

