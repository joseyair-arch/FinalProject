package Finalproject.gui;

import project.Book;
import service.Library;
import javax.swing.*;
import java.awt.*;

public class BookForm extends JFrame {

    public BookForm(Library library) {

        setTitle("Registrar Libro");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel lblCode = new JLabel("Código:");
        JTextField txtCode = new JTextField();

        JLabel lblTitle = new JLabel("Título:");
        JTextField txtTitle = new JTextField();

        JLabel lblAuthor = new JLabel("Autor:");
        JTextField txtAuthor = new JTextField();

        JLabel lblYear = new JLabel("Año:");
        JTextField txtYear = new JTextField();

        JButton btnSave = new JButton("Guardar");

        add(lblCode);   add(txtCode);
        add(lblTitle);  add(txtTitle);
        add(lblAuthor); add(txtAuthor);
        add(lblYear);   add(txtYear);
        add(btnSave);

        btnSave.addActionListener(e -> {
            try {
                String code   = txtCode.getText();
                String title  = txtTitle.getText();
                String author = txtAuthor.getText();
                int year      = Integer.parseInt(txtYear.getText());

                // orden correcto: code, title, author, year
                Book book = new Book(code, title, author, year);

                boolean added = library.addMaterial(book);

                if (added) {
                    JOptionPane.showMessageDialog(null, "Libro registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Código repetido");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: verifica los datos");
            }
        });

        setVisible(true);
    }
}