package Finalproject.gui;

import service.Library;

import javax.swing.*;
import java.awt.*;

public class LoanForm extends JFrame {

    public LoanForm(Library library) {

        setTitle("Realizar Préstamo");

        setSize(300,200);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,2));

        JLabel lblUser =
                new JLabel("ID Usuario:");

        JTextField txtUser =
                new JTextField();

        JLabel lblMaterial =
                new JLabel("Código Material:");

        JTextField txtMaterial =
                new JTextField();

        JButton btnLoan =
                new JButton("Prestar");

        add(lblUser);
        add(txtUser);

        add(lblMaterial);
        add(txtMaterial);

        add(btnLoan);

        btnLoan.addActionListener(e -> {

            String userId =
                    txtUser.getText();

            String materialCode =
                    txtMaterial.getText();

            boolean success =
                    library.makeLoan(
                            userId,
                            materialCode
                    );

            if(success){

                JOptionPane.showMessageDialog(
                        null,
                        "Préstamo realizado"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "No se pudo realizar"
                );

            }

        });

        setVisible(true);

    }

}