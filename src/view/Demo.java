package view;

import model.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Demo {

    private final Color violet = new Color(110, 74, 227);
    private final Color violetF = new Color(42,0,51);
    private JPanel rootPanel;
    private JFrame frame;
    private JButton SUIVANTButton;
    private JButton PRECEDENTButton;

    public Demo() {

        frame = new JFrame();
        frame.setSize(1600,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(rootPanel);

        rootPanel.setVisible(true);

        SUIVANTButton.setBackground(violet);
        SUIVANTButton.setForeground(Color.white);
        SUIVANTButton.setBorderPainted(false);
        SUIVANTButton.setFocusable(false);

        PRECEDENTButton.setBackground(violet);
        PRECEDENTButton.setForeground(Color.white);
        PRECEDENTButton.setBorderPainted(false);
        PRECEDENTButton.setFocusable(false);


        SUIVANTButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SUIVANTButton.setBackground(Color.white);
                SUIVANTButton.setForeground(Color.black);

            }
        });
        SUIVANTButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SUIVANTButton.setBackground(violet);
                SUIVANTButton.setForeground(Color.white);

            }
        });
        PRECEDENTButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PRECEDENTButton.setBackground(Color.white);
                PRECEDENTButton.setForeground(Color.black);

            }
        });
        PRECEDENTButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PRECEDENTButton.setBackground(violet);
                PRECEDENTButton.setForeground(Color.white);

            }
        });
    }
}
