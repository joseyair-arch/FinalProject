package persistence;


import service.Library;

import java.io.*;

import project.Book;
import project.Loan;
import project.Material;
import project.Student;
import project.Teacher;
import project.User;

public class Persistence {

    private static final String BOOKS_FILE = "books.csv";
    private static final String USERS_FILE = "users.csv";
    private static final String LOANS_FILE = "loans.csv";

    
    public static void saveData(Library library) {

     	System.out.println("SAVE DATA EXECUTED");
        saveBooks(library);
        saveUsers(library);
        saveLoans(library);

    }

    

    public static void loadData(Library library) {

        loadBooks(library);
        loadUsers(library);
        loadLoans(library);

    }

    

    private static void saveBooks(Library library) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(BOOKS_FILE))) {

            bw.write("code,title,author,year,available");
            bw.newLine();

            for (Material material : library.getMaterials()) {

                if (material instanceof Book) {

                    Book book = (Book) material;

                    bw.write(
                            book.getCode() + "," +
                            book.getTitle() + "," +
                            book.getAuthor() + "," +
                            book.getYear() + "," +
                            book.isAvailable()
                    );

                    bw.newLine();
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void loadBooks(Library library) {

        File file = new File(BOOKS_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(file))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                Book book =
                        new Book(
                                data[0],
                                data[1],
                                data[2],
                                Integer.parseInt(data[3])
                        );

                book.setAvailable(
                        Boolean.parseBoolean(
                                data[4]
                        )
                );

                library.addMaterial(book);

            }

        } catch (Exception e) {

            System.out.println(
                    "Error loading books: "
                            + e.getMessage()
            );
        }
    }

    

    private static void saveUsers(Library library) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(USERS_FILE))) {

            bw.write("id,name,type");
            bw.newLine();

            for (User user : library.getUsers()) {

                String type =
                        user instanceof Teacher
                                ? "Teacher"
                                : "Student";

                bw.write(
                        user.getId() + "," +
                        user.getName() + "," +
                        type
                );

                bw.newLine();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void loadUsers(Library library) {

        File file = new File(USERS_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(file))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                User user;

                if ("Teacher".equals(data[2])) {

                    user =
                            new Teacher(
                                    data[0],
                                    data[1]
                            );

                } else {

                    user =
                            new Student(
                                    data[0],
                                    data[1]
                            );

                }

                library.addUser(user);

            }

        } catch (Exception e) {

            System.out.println(
                    "Error loading users: "
                            + e.getMessage()
            );
        }
    }

    

    private static void saveLoans(Library library) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(LOANS_FILE))) {

            bw.write("userId,materialCode");
            bw.newLine();

            for (Loan loan : library.getLoans()) {

                bw.write(
                        loan.getUser().getId() + "," +
                        loan.getMaterial().getCode()
                );

                bw.newLine();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void loadLoans(Library library) {

        File file = new File(LOANS_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(file))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                User user =
                        library.searchUser(
                                data[0]
                        );

                Material material =
                        library.searchMaterial(
                                data[1]
                        );

                if (user != null &&
                        material != null) {

                    material.setAvailable(false);

                    library.getLoans().add(
                            new Loan(
                                    user,
                                    material
                            )
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error loading loans: "
                            + e.getMessage()
            );
        }
    }
}