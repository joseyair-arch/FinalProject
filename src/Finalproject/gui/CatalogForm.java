package Finalproject.gui;

import project.Material;
import service.Library;

import javax.swing.*;
import java.awt.*;

public class CatalogForm extends JFrame {

    public CatalogForm(Library library) {

        setTitle("Catálogo");

        setSize(400,300);

        setLocationRelativeTo(null);

        JTextArea area =
                new JTextArea();

        for(Material m : library.getMaterials()) {

            area.append(
                    m.getCode()
                    + " - "
                    + m.getTitle()
                    + "\n"
            );

        }

        add(new JScrollPane(area));

        setVisible(true);

    }

}