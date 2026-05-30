package Finalproject.gui;

import project.Student;
import project.Teacher;
import project.User;
import service.Library;
import javax.swing.*;
import java.awt.*;

public class UserForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserForm(Library library) {

        setTitle("Registrar Usuario");
        setSize(350, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(MainMenu.BG);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Registrar Usuario", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(MainMenu.TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBackground(MainMenu.BG);
        form.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JTextField txtId   = BookForm.crearCampo();
        JTextField txtName = BookForm.crearCampo();

        JComboBox<String> cmbType = new JComboBox<>(new String[]{"Estudiante", "Docente"});
        cmbType.setBackground(new Color(70, 50, 110));
        cmbType.setForeground(MainMenu.TEXT);
        cmbType.setFont(MainMenu.FONT);

        form.add(BookForm.crearLabel("ID:"));      form.add(txtId);
        form.add(BookForm.crearLabel("Nombre:"));  form.add(txtName);
        form.add(BookForm.crearLabel("Tipo:"));    form.add(cmbType);

        add(form, BorderLayout.CENTER);

        JButton btnSave = MainMenu.crearBoton("Guardar");
        JPanel bottom = new JPanel(new GridLayout(1,1));
        bottom.setBackground(MainMenu.BG);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        bottom.add(btnSave);
        add(bottom, BorderLayout.SOUTH);

        btnSave.addActionListener(e -> {
            String id   = txtId.getText();
            String name = txtName.getText();
            String type = cmbType.getSelectedItem().toString();

            User user = type.equals("Student") ? new Student(id, name) : new Teacher(id, name);
            boolean added = library.addUser(user);

            if (added) {
                JOptionPane.showMessageDialog(null, "Usuario registrado");
            } else {
                JOptionPane.showMessageDialog(null, "ID repetido");
            }
        });

        setVisible(true);
    }
}