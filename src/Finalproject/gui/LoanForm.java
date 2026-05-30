package Finalproject.gui;

import service.Library;
import javax.swing.*;
import java.awt.*;

public class LoanForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoanForm(Library library) {

        setTitle("Realizar Préstamo");
        setSize(350, 260);
        setLocationRelativeTo(null);
        getContentPane().setBackground(MainMenu.BG);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Realizar Préstamo", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(MainMenu.TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));
        form.setBackground(MainMenu.BG);
        form.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JTextField txtUser     = BookForm.crearCampo();
        JTextField txtMaterial = BookForm.crearCampo();

        form.add(BookForm.crearLabel("ID Usuario:"));
        form.add(txtUser);
        form.add(BookForm.crearLabel("Código Material:"));
        form.add(txtMaterial);

        add(form, BorderLayout.CENTER);

        JButton btnLoan = MainMenu.crearBoton(" Prestar");
        JPanel bottom = new JPanel(new GridLayout(1, 1));
        bottom.setBackground(MainMenu.BG);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        bottom.add(btnLoan);
        add(bottom, BorderLayout.SOUTH);

        btnLoan.addActionListener(e -> {
            boolean success = library.makeLoan(
                    txtUser.getText(),
                    txtMaterial.getText()
            );
            if (success) {
                JOptionPane.showMessageDialog(null, "Préstamo realizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar");
            }
        });

        setVisible(true);
    }
}