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

public class Menu3 extends  JFrame{

    final JFrame frame = new JFrame("BATAILLE NAVALE");
    private JPanel rootPanel;
    private JComboBox comboBox1;
    private JTextField NOMBREDEBATEAUXÀTextField;
    private JButton VALIDER;

    final Color violet = new Color(110,74,227);
    final Color violetF = new Color(42,0,51);



    public Menu3(Partie p){

        this.setUndecorated(true);
        setSize(0, 0);
        final JFrame frame = new JFrame("BATAILLE NAVALE");
        this.setLocationRelativeTo(null); //centre au milieu de l'ecran
        this.setVisible(false);


        final Runnable runnable = new Runnable() {
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


        SwingUtilities.invokeLater(runnable);

        rootPanel.setBackground(violetF);
        VALIDER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage a = new Affichage(false,p);
                BatailleController c = new BatailleController(a, p);
                a.setVisible(true);
                frame.dispose();
                dispose();
            }
        });


        VALIDER.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                VALIDER.setBackground(Color.white);
                VALIDER.setForeground(Color.black);

            }
        });
        VALIDER.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                VALIDER.setBackground(violet);
                VALIDER.setForeground(Color.white);

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.nbBateau = (comboBox1.getSelectedIndex()+1);

            }
        });
    }


    public class FrameDragListener extends MouseAdapter {

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
