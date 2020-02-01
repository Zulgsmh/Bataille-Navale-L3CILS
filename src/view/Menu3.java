package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu3 extends  JFrame{
    final JFrame frame = new JFrame("BATAILLE NAVALE");
    private JPanel rootPanel;
    private JComboBox comboBox1;
    private JTextField NOMBREDEBATEAUXÀTextField;
    private JButton button1;
    private Partie p;

    Color violet = new Color(110,74,227);
    Color violetF = new Color(42,0,51);

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            frame.setUndecorated(true);
            frame.setBounds(0, 0, 800, 200);
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

    public Menu3(Partie p){
        this.p = p;

        SwingUtilities.invokeLater(runnable);

        rootPanel.setBackground(violetF);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage a = new Affichage();
                BatailleController c = new BatailleController(a, p);
                a.setVisible(true);
                frame.dispose();
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
