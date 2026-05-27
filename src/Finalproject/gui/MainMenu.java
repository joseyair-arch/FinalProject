package Finalproject.gui;

import service.Library;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private Library library;

    public MainMenu() {

        library = new Library();

        setTitle("Biblioteca 2.0");

        setSize(400, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(7, 1, 10, 10));

        JButton btnBook =
                new JButton("Registrar Libro");

        JButton btnUser =
                new JButton("Registrar Usuario");

        JButton btnLoan =
                new JButton("Realizar Préstamo");

        JButton btnReturn =
                new JButton("Devolver Material");

        JButton btnCatalog =
                new JButton("Ver Catálogo");

        JButton btnLoans =
                new JButton("Ver Préstamos");

        JButton btnExit =
                new JButton("Salir");

        panel.add(btnBook);
        panel.add(btnUser);
        panel.add(btnLoan);
        panel.add(btnReturn);
        panel.add(btnCatalog);
        panel.add(btnLoans);
        panel.add(btnExit);

        add(panel);

        btnExit.addActionListener(e -> System.exit(0));

        // OPEN BOOK FORM
        btnBook.addActionListener(e -> {

            new BookForm(library);

        });

        setVisible(true);

    }

    public static void main(String[] args) {

        new MainMenu();

    }

}