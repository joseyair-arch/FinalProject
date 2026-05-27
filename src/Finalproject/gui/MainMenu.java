package Finalproject.gui;

import service.Library;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private Library library;

    // COLORES MORADOS
    static final Color BG = new Color(30, 20, 50);
    static final Color PANEL = new Color(50, 35, 80);
    static final Color BTN = new Color(120, 60, 200);
    static final Color BTN_HOVER = new Color(150, 90, 230);
    static final Color TEXT = new Color(240, 230, 255);
    static final Font FONT = new Font("Segoe UI", Font.BOLD, 14);

    public MainMenu() {

        library = new Library();

        setTitle("Biblioteca 2.0");
        setSize(400, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout(10, 10));

        // TÍTULO
        JLabel titulo = new JLabel(" Biblioteca 2.0", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // PANEL DE BOTONES
        JPanel panel = new JPanel();
        panel.setBackground(BG);
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 30, 40));

        JButton btnBook    = crearBoton("Registrar Libro");
        JButton btnUser    = crearBoton(" Registrar Usuario");
        JButton btnLoan    = crearBoton(" Realizar Préstamo");
        JButton btnReturn  = crearBoton("Devolver Material");
        JButton btnCatalog = crearBoton("Ver Catálogo");
        JButton btnLoans   = crearBoton(" Ver Préstamos");
        JButton btnExit    = crearBoton("Salir");
        btnExit.setBackground(new Color(180, 50, 50));

        panel.add(btnBook);
        panel.add(btnUser);
        panel.add(btnLoan);
        panel.add(btnReturn);
        panel.add(btnCatalog);
        panel.add(btnLoans);
        panel.add(btnExit);

        add(panel, BorderLayout.CENTER);

        btnExit.addActionListener(e -> System.exit(0));
        btnBook.addActionListener(e -> new BookForm(library));
        btnUser.addActionListener(e -> new UserForm(library));
        btnLoan.addActionListener(e -> new LoanForm(library));
        btnReturn.addActionListener(e -> new ReturnForm(library));
        btnCatalog.addActionListener(e -> new CatalogForm(library));
        btnLoans.addActionListener(e -> new LoansForm(library));

        setVisible(true);
    }

    static JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(FONT);
        btn.setBackground(BTN);
        btn.setForeground(TEXT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(BTN_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(BTN);
            }
        });
        return btn;
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}