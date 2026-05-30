package Finalproject.gui;

import project.Book;
import service.Library;
import javax.swing.*;

import persistence.Persistence;

import java.awt.*;

public class BookForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookForm(Library library) {

        setTitle("Registrar Libro");
        setSize(350, 320);
        setLocationRelativeTo(null);
        getContentPane().setBackground(MainMenu.BG);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Registrar Libro", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(MainMenu.TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBackground(MainMenu.BG);
        form.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JTextField txtCode   = crearCampo();
        JTextField txtTitle  = crearCampo();
        JTextField txtAuthor = crearCampo();
        JTextField txtYear   = crearCampo();

        form.add(crearLabel("Código:"));   form.add(txtCode);
        form.add(crearLabel("Título:"));   form.add(txtTitle);
        form.add(crearLabel("Autor:"));    form.add(txtAuthor);
        form.add(crearLabel("Año:"));      form.add(txtYear);

        add(form, BorderLayout.CENTER);

        JButton btnSave = MainMenu.crearBoton("Guardar");
        JPanel bottom = new JPanel();
        bottom.setBackground(MainMenu.BG);
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        bottom.setLayout(new GridLayout(1,1));
        bottom.add(btnSave);
        add(bottom, BorderLayout.SOUTH);

        btnSave.addActionListener(e -> {
            try {
                String code   = txtCode.getText();
                String title  = txtTitle.getText();
                String author = txtAuthor.getText();
                int year      = Integer.parseInt(txtYear.getText());

                Book book = new Book(code, title, author, year);
                boolean added = library.addMaterial(book);
                System.out.println("Books in library: " +
                        library.getMaterials().size());

                if (added) {
                	Persistence.saveData(library);
                    JOptionPane.showMessageDialog(null, "Libro registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Código repetido");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Error: verifica los datos");
            }
        });

        setVisible(true);
    }

    static JLabel crearLabel(String texto) {
        JLabel l = new JLabel(texto);
        l.setForeground(MainMenu.TEXT);
        l.setFont(MainMenu.FONT);
        return l;
    }

    static JTextField crearCampo() {
        JTextField t = new JTextField();
        t.setBackground(new Color(70, 50, 110));
        t.setForeground(MainMenu.TEXT);
        t.setCaretColor(MainMenu.TEXT);
        t.setFont(MainMenu.FONT);
        t.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        return t;
    }
}