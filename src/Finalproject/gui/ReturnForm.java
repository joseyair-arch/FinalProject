package Finalproject.gui;

import service.Library;

import javax.swing.*;
import java.awt.*;

public class ReturnForm extends JFrame {

    public ReturnForm(Library library) {

        setTitle("Devolver Material");

        setSize(300,150);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        JLabel lblCode =
                new JLabel("Código:");

        JTextField txtCode =
                new JTextField();

        JButton btnReturn =
                new JButton("Devolver");

        add(lblCode);
        add(txtCode);

        add(btnReturn);

        btnReturn.addActionListener(e -> {

            String code =
                    txtCode.getText();

            boolean success =
                    library.returnMaterial(code);

            if(success){

                JOptionPane.showMessageDialog(
                        null,
                        "Material devuelto"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "No encontrado"
                );

            }

        });

        setVisible(true);

    }

}