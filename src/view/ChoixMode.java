package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoixMode extends JFrame {

    private JButton ALERTEROUGEButton;
    private JPanel rootPanel;
    private JButton BATAILLENAVALEButton;
    private JButton OPERATIONARTILLERIEButton;
    private JButton MISSIONRADARButton;
    private JButton button1;

    Color purple = new Color(110, 74, 227);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public ChoixMode() {
        setSize(800, 300);
        add(rootPanel);
        this.setUndecorated(true);


        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                BATAILLENAVALEButton.setBackground(Color.white);
                BATAILLENAVALEButton.setForeground(Color.black);


            }
        });
        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                BATAILLENAVALEButton.setBackground(purple);
                BATAILLENAVALEButton.setForeground(Color.white);

            }
        });
        OPERATIONARTILLERIEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                OPERATIONARTILLERIEButton.setBackground(Color.white);
                OPERATIONARTILLERIEButton.setForeground(Color.black);

            }
        });
        OPERATIONARTILLERIEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                OPERATIONARTILLERIEButton.setBackground(purple);
                OPERATIONARTILLERIEButton.setForeground(Color.white);

            }
        });
        MISSIONRADARButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                MISSIONRADARButton.setBackground(Color.white);
                MISSIONRADARButton.setForeground(Color.black);

            }
        });
        MISSIONRADARButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                MISSIONRADARButton.setBackground(purple);
                MISSIONRADARButton.setForeground(Color.white);

            }
        });
        ALERTEROUGEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ALERTEROUGEButton.setBackground(Color.white);
                ALERTEROUGEButton.setForeground(Color.black);

            }
        });
        ALERTEROUGEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ALERTEROUGEButton.setBackground(purple);
                ALERTEROUGEButton.setForeground(Color.white);

            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button1.setBackground(Color.white);
                button1.setForeground(Color.black);

            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button1.setBackground(purple);
                button1.setForeground(Color.white);

            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Gui g1 = new Gui();
                g1.setLocation(rootPanel.getLocation());
                g1.setVisible(true);

                dispose();
            }
        });
        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Partie p = new Partie();
                Affichage a = new Affichage();
                BatailleController c = new BatailleController(a, p);
                a.setVisible(true);
            }
        });
    }

}
