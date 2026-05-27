package Finalproject.gui;

import project.Student;
import project.Teacher;
import project.User;
import service.Library;

import javax.swing.*;
import java.awt.*;

public class UserForm extends JFrame {

    public UserForm(Library library) {

        setTitle("Registrar Usuario");

        setSize(300,300);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,2));

        JLabel lblId =
                new JLabel("ID:");

        JTextField txtId =
                new JTextField();

        JLabel lblName =
                new JLabel("Nombre:");

        JTextField txtName =
                new JTextField();

        JLabel lblType =
                new JLabel("Tipo:");

        String[] types = {
                "Student",
                "Teacher"
        };

        JComboBox<String> cmbType =
                new JComboBox<>(types);

        JButton btnSave =
                new JButton("Guardar");

        add(lblId);
        add(txtId);

        add(lblName);
        add(txtName);

        add(lblType);
        add(cmbType);

        add(btnSave);

        btnSave.addActionListener(e -> {

            String id =
                    txtId.getText();

            String name =
                    txtName.getText();

            String type =
                    cmbType.getSelectedItem().toString();

            User user;

            if(type.equals("Student")) {

                user = new Student(id, name);

            } else {

                user = new Teacher(id, name);

            }

            boolean added =
                    library.addUser(user);

            if(added){

                JOptionPane.showMessageDialog(
                        null,
                        "Usuario registrado"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "ID repetido"
                );

            }

        });

        setVisible(true);

    }

}