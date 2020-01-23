package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame {
    Color purple = new Color(110,74,227);
    private JPanel rootPanel;
    private JButton DEMO;
    private JButton UN;
    private JButton DEUX;

    public Gui(){
        add(rootPanel);
        setTitle("BATAILLE NAVALE");
        setSize(800,500);

        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                UN.setBackground(Color.white);
            }
        });
        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                UN.setBackground(purple);
            }
        });
        DEUX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                DEUX.setBackground(Color.white);
            }
        });
        DEUX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                DEUX.setBackground(purple);
            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                DEMO.setBackground(Color.white);
            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                DEMO.setBackground(purple);
            }
        });
    }

}
