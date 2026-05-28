# Biblioteca 2.0

## Description
Desktop application developed in Java with a graphical interface (Swing) that simulates the basic operation of a library.

The system allows registering books, registering users, managing loans and returns of materials, all from a main menu with a modern design in purple tones.


## Team Members
- Jose Yair Hernandez Valenzuela
- Emerson Javier Jimenez Juarez
- Joselyn Marleni Lopez y Lopez

## Project Option
Option B — Library 2.0

## Features
- Register books (code, title, author, year)
- Register users (Student or Teacher)
- Make material loans
- Return materials
- View catalog of registered materials
- View list of active loans

## Project Structure

FinalProject/
├── src/
│   ├── Finalproject/
│   │   └── gui/
│   │       ├── MainMenu.java
│   │       ├── BookForm.java
│   │       ├── UserForm.java
│   │       ├── LoanForm.java
│   │       ├── ReturnForm.java
│   │       ├── CatalogForm.java
│   │       └── LoansForm.java
│   ├── project/
│   │   ├── Material.java
│   │   ├── Book.java
│   │   ├── Loan.java
│   │   ├── User.java
│   │   ├── Student.java
│   │   └── Teacher.java
│   └── service/
│       └── Library.java


## Requirements
- Java JDK 11 or higher
- Eclipse IDE or any Java-compatible IDE

## How to Clone the Repository

1. Open the terminal or CMD
2. Type the following command:

git clone https://github.com/joseyair-arch/FinalProject.git

3. Enter the project folder:

cd FinalProject

## How to Run the Project

From Eclipse

1. Open Eclipse
2. Go to File → Import
3. Select Existing Projects into Workspace
4. Find the project folder and select it
5. Click Finish
6. Find the file MainMenu.java inside Finalproject/gui
7. Right-click → Run As → Java Application

## Project Status
Completed and functional

## Notes
- Users can be of type Student (loan limit of 3) or Teacher (loan limit of 5)
- Duplicate book codes or user IDs are not allowed
- The graphical interface was designed with a dark theme in purple tones