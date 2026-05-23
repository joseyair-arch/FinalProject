package Finalproject.gui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {

        setTitle("Library 2.0");

        setSize(400, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(7, 1, 10, 10));

        JButton btnBook =
                new JButton("Register Book");

        JButton btnUser =
                new JButton("Register User");

        JButton btnLoan =
                new JButton("Loan Material");

        JButton btnReturn =
                new JButton("Return Material");

        JButton btnCatalog =
                new JButton("View Catalog");

        JButton btnLoans =
                new JButton("View Loans");

        JButton btnExit =
                new JButton("Exit");

        panel.add(btnBook);
        panel.add(btnUser);
        panel.add(btnLoan);
        panel.add(btnReturn);
        panel.add(btnCatalog);
        panel.add(btnLoans);
        panel.add(btnExit);

        add(panel);

        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);

    }

    public static void main(String[] args) {

        new MainMenu();

    }

}