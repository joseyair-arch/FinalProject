package Finalproject.gui;

import project.Material;
import service.Library;
import javax.swing.*;
import java.awt.*;

public class CatalogForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogForm(Library library) {

        setTitle("Catálogo");
        setSize(420, 320);
        setLocationRelativeTo(null);
        getContentPane().setBackground(MainMenu.BG);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Catálogo de Materiales", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(MainMenu.TEXT);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
        add(titulo, BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setBackground(new Color(50, 35, 80));
        area.setForeground(MainMenu.TEXT);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setEditable(false);
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Material m : library.getMaterials()) {
            area.append("" + m.getCode() + " — " + m.getTitle() + "\n");
        }

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        scroll.getViewport().setBackground(new Color(50, 35, 80));
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}