package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame {
    Color purple = new Color(110,74,227);
    Color dRed = new Color(227,64,88);
    private JPanel rootPanel;
    private JButton DEMO;
    private JButton UN;
    private JButton DEUX;
    private JPanel img;
    private JTextField BATAILLENAVALETextField;
    private JButton xButton;

    public Gui(){
        add(rootPanel);
        this.setUndecorated(true);
        setTitle("BATAILLE NAVALE");
        setSize(800,300);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Hello");
                frame.setUndecorated(true);
                frame.setBounds(0, 0, 800, 300);
                frame.setContentPane(rootPane);
                FrameDragListener frameDragListener = new FrameDragListener(frame);
                frame.addMouseListener(frameDragListener);
                frame.addMouseMotionListener(frameDragListener);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
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
                UN.setBackground(purple);
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
                DEUX.setBackground(purple);
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
                DEMO.setBackground(purple);
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
                ChoixMode m1 = new ChoixMode();
                m1.setLocationRelativeTo(null);

                m1.setVisible(true);
                dispose();

            }
        });
        DEMO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ChoixMode m1 = new ChoixMode();
                m1.setLocationRelativeTo(null);

                m1.setVisible(true);
                dispose();

            }
        });
        UN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ChoixMode m1 = new ChoixMode();
                m1.setLocationRelativeTo(null);

                m1.setVisible(true);
                dispose();

            }
        });
        xButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });

        SwingUtilities.invokeLater(runnable);

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
