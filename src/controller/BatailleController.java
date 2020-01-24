package controller;
import view.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BatailleController {
    private Affichage affichage;
    private Partie partie;

    public BatailleController(Affichage affichage, Partie partie){
        this.affichage = affichage;
        this.partie = partie;

        this.affichage.addjvjListener(new menuListener(false,false));
        this.affichage.addjvoListener(new menuListener(false, true));
        this.affichage.addovoListener(new menuListener(true, true));
        this.affichage.addclassiqueListener(new modeListener("classique"));
        this.affichage.addradarListener(new modeListener("radar"));
        this.affichage.addartillerieListener(new modeListener("artillerie"));
        this.affichage.addcoderougeListener(new modeListener("coderouge"));
        this.affichage.addGrille1Listener(new ListenForMouse());
        this.affichage.addGrille2Listener(new ListenForMouse());
        //this.affichage.addcelluleListener(new cellulListener());

    }

    class menuListener implements ActionListener{
        boolean j1, j2;
        menuListener(Boolean j1, Boolean j2){
            this.j1 = j1;
            this.j2 = j2;
        }
        public void actionPerformed(ActionEvent e) {
            partie.j1.setEstOrdi(this.j1);
            partie.j2.setEstOrdi(this.j2);
            affichage.setContainer("mode");
        }
    }
    class modeListener implements ActionListener{
        String mode;
        modeListener(String mode){
            this.mode = mode;
        }
        public void actionPerformed(ActionEvent e) {
            partie.ModeJ = this.mode;
            affichage.setContainer("plateau");
            partie.nbBateau = 5;
            partie.placerBateauJ1();
            partie.placerBateauJ2();
            affichage.drawGrille1(partie.j1.maGrille);
            affichage.drawGrille2(partie.j2.maGrille);
        }
    }
    public class ListenForMouse implements MouseListener {

        // Called when a mouse button is clicked

        public void mouseClicked(MouseEvent e) {
            cellule parent = (cellule)e.getSource();
            System.out.println("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");

            //System.out.println("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            System.out.println(parent.getx() + " " + parent.gety());
            System.out.println("Mouse Button: " + e.getButton()  + "\n");
            if (parent.getAppartient().equals("j1")){
                System.out.println("Grille1");
                partie.j1.getShot(parent.getx()+1, parent.gety()+1);
                affichage.drawGrille1(partie.j1.maGrille);
            }else{
                System.out.println("Grille2");
                partie.j2.getShot(parent.getx()+1, parent.gety()+1);
                affichage.drawGrille2(partie.j2.maGrille);
            }

            System.out.println("Mouse Clicks: " + e.getClickCount()  + "\n");

        }

        // Called when the mouse enters the component assigned

        // the MouseListener

        public void mouseEntered(MouseEvent e) {
            JPanel parent = (JPanel)e.getSource();
            if (parent.getBackground().equals(Color.CYAN)) {
                parent.setBackground(Color.gray);
            }
            //parent.revalidate();
        }
        // Called when the mouse leaves the component assigned
        // the MouseListener

        public void mouseExited(MouseEvent e) {
            JPanel parent = (JPanel)e.getSource();
            if (parent.getBackground().equals(Color.gray)) {
                parent.setBackground(Color.CYAN);
            }
        }
        // Mouse button pressed
        public void mousePressed(MouseEvent arg0) {
        }
        // Mouse button released
        public void mouseReleased(MouseEvent arg0) {

        }
    }

}
