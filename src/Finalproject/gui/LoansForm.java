package Finalproject.gui;

import project.Loan;
import service.Library;

import javax.swing.*;
import java.awt.*;

public class LoansForm extends JFrame {

    public LoansForm(Library library) {

        setTitle("Préstamos");

        setSize(400,300);

        setLocationRelativeTo(null);

        JTextArea area =
                new JTextArea();

        for(Loan l : library.getLoans()) {

            area.append(
                    l.toString()
                    + "\n"
            );

        }

        add(new JScrollPane(area));

        setVisible(true);

    }

}