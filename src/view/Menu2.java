package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu2 extends JFrame {

    private JButton ALERTEROUGEButton;
    private JPanel rootPanel;
    private JButton BATAILLENAVALEButton;
    private JButton OPERATIONARTILLERIEButton;
    private JButton MISSIONRADARButton;
    private JButton button1;
    private Partie p;

    Color purple = new Color(110, 74, 227);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Menu2(Partie p) {
        setSize(800, 300);
        this.setUndecorated(true);
        final JFrame frame = new JFrame("BATAILLE NAVALE");
        this.p = p;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                frame.setUndecorated(true);
                frame.setBounds(0, 0, 800, 300);
                frame.setContentPane(rootPanel);
                Menu1.FrameDragListener frameDragListener = new Menu1.FrameDragListener(frame);
                frame.addMouseListener(frameDragListener);
                frame.addMouseMotionListener(frameDragListener);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                rootPanel.setVisible(true);
                pack();
            }
        };


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
                Menu1 g1 = new Menu1();
                g1.setLocation(rootPanel.getLocation());
                g1.setVisible(true);
                p.setTypeNormal(true);
                frame.dispose();
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

                Menu3 m3 = new Menu3(p);
                m3.setVisible(true);
                frame.dispose();
                dispose();
            }
        });
        SwingUtilities.invokeLater(runnable);

        MISSIONRADARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setTypeRadar(true);
                Menu3 m3 = new Menu3(p);
                m3.setVisible(true);
                frame.dispose();
                dispose();
            }
        });
        OPERATIONARTILLERIEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setTypeArti(true);
                Menu3 m3 = new Menu3(p);
                m3.setVisible(true);
                frame.dispose();
                dispose();
            }
        });
        ALERTEROUGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setTypeAR(true);
                Menu3 m3 = new Menu3(p);
                m3.setVisible(true);
                frame.dispose();
                dispose();
            }
        });
    }
    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
            System.out.println(frame.getLocation());

        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);

        }

    }

}
