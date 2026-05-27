package Finalproject.gui;

import service.Library;
import javax.swing.*;
import java.awt.*;

public class ReturnForm extends JFrame {

    public ReturnForm(Library library) {

        setTitle("Devolver Material");
        setSize(350, 210);
        setLocationRelativeTo(null);
        getContentPane().setBackground(MainMenu.BG);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(" Devolver Material", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(MainMenu.TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(1, 2, 10, 10));
        form.setBackground(MainMenu.BG);
        form.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JTextField txtCode = BookForm.crearCampo();
        form.add(BookForm.crearLabel("Código:"));
        form.add(txtCode);
        add(form, BorderLayout.CENTER);

        JButton btnReturn = MainMenu.crearBoton("Devolver");
        JPanel bottom = new JPanel(new GridLayout(1,1));
        bottom.setBackground(MainMenu.BG);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        bottom.add(btnReturn);
        add(bottom, BorderLayout.SOUTH);

        btnReturn.addActionListener(e -> {
            boolean success = library.returnMaterial(txtCode.getText());
            if (success) {
                JOptionPane.showMessageDialog(null, "Material devuelto");
            } else {
                JOptionPane.showMessageDialog(null, " No encontrado");
            }
        });

        setVisible(true);
    }
}