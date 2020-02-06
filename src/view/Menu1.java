package view;

import controller.BatailleController;
import model.Partie;
import view.plateau.Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu1 extends JFrame {

    private final Color violet = new Color(110, 74, 227);
    private final Color dRed = new Color(227, 64, 88);
    private JPanel rootPanel;
    private JButton DEMO;
    private JButton UN;
    private JButton DEUX;
    private JPanel img;
    private JTextField BATAILLENAVALETextField;
    private JButton xButton;
    private final Partie p;

    public Menu1() {

        this.setUndecorated(true);
        setSize(0, 0);
        final JFrame frame = new JFrame("BATAILLE NAVALE");
        this.setLocationRelativeTo(null); //centre au milieu de l'ecran
        this.setVisible(false);
        p = new Partie();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                frame.setUndecorated(true);
                frame.setBounds(0, 0, 800, 300);
                frame.setContentPane(rootPanel);
                FrameDragListener frameDragListener = new FrameDragListener(frame);
                frame.addMouseListener(frameDragListener);
                frame.addMouseMotionListener(frameDragListener);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                rootPanel.setVisible(true);
                pack();
            }
        };


        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                UN.setBackground(Color.white);
                UN.setForeground(Color.black);

            }
        });
        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                UN.setBackground(violet);
                UN.setForeground(Color.white);

            }
        });
        DEUX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                DEUX.setBackground(Color.white);
                DEUX.setForeground(Color.black);
            }
        });
        DEUX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                DEUX.setBackground(violet);
                DEUX.setForeground(Color.white);
            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                DEMO.setBackground(Color.white);
                DEMO.setForeground(Color.black);

            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                DEMO.setBackground(violet);
                DEMO.setForeground(Color.white);

            }
        });
        xButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                xButton.setBackground(Color.white);
                xButton.setForeground(Color.black);

            }
        });
        xButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                xButton.setBackground(dRed);
                xButton.setForeground(Color.white);

            }
        });
        DEUX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Menu2 m1 = new Menu2(p);
                m1.setVisible(true);
                dispose();
                frame.dispose();


            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Affichage a = new Affichage(true,p);
                BatailleController c = new BatailleController(a, p);
                a.setVisible(true);
                frame.dispose();
                dispose();


            }
        });
        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Menu2 m1 = new Menu2(p);
                m1.setVisible(true);
                dispose();
                frame.dispose();

            }
        });
        xButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                frame.dispose();
            }
        });

        SwingUtilities.invokeLater(runnable);

        DEUX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.j1.setEstOrdi(false);
                p.j2.setEstOrdi(false);
            }
        });
        UN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.j1.setEstOrdi(false);
                p.j2.setEstOrdi(true);
            }
        });
        DEMO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.j1.setEstOrdi(true);
                p.j2.setEstOrdi(true);
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
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);

        }

    }



}
