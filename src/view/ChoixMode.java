package view;

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
    Color purple = new Color(110,74,227);

    public ChoixMode() {
        setSize(800, 300);
        add(rootPanel);
        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                BATAILLENAVALEButton.setBackground(Color.white);
            }
        });
        BATAILLENAVALEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                BATAILLENAVALEButton.setBackground(purple);
            }
        });
        OPERATIONARTILLERIEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                OPERATIONARTILLERIEButton.setBackground(Color.white);
            }
        });
        OPERATIONARTILLERIEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                OPERATIONARTILLERIEButton.setBackground(purple);
            }
        });  MISSIONRADARButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                MISSIONRADARButton.setBackground(Color.white);
            }
        });
        MISSIONRADARButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                MISSIONRADARButton.setBackground(purple);
            }
        });
        ALERTEROUGEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ALERTEROUGEButton.setBackground(Color.white);
            }
        });
        ALERTEROUGEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ALERTEROUGEButton.setBackground(purple);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button1.setBackground(Color.white);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button1.setBackground(purple);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Gui g1 = new Gui();
                g1.setVisible(true);
                dispose();
            }
        });
    }

}
