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

        //*****************            Menu           *****************
        this.affichage.addjvjListener(new menuListener(false,false));
        this.affichage.addjvoListener(new menuListener(false, true));
        this.affichage.addovoListener(new menuListener(true, true));

        //*****************          NbBateau           *****************
        this.affichage.addValidNBListener(new ValidNBListen());

        //*****************          Mode           *****************
        this.affichage.addclassiqueListener(new modeListener("classique"));
        this.affichage.addradarListener(new modeListener("radar"));
        this.affichage.addartillerieListener(new modeListener("artillerie"));
        this.affichage.addcoderougeListener(new modeListener("coderouge"));

        //*****************          Plateau           *****************
        this.affichage.addGrille1Listener(new ListenForMouse());
        this.affichage.addGrille2Listener(new ListenForMouse());
        this.affichage.addlistBateauJ1Listener(new ListenForBateauJ1());
        this.affichage.addlistBateauJ2Listener(new ListenForBateauJ2());
        this.affichage.addvaliderPlacementListener(new ListenForPlacement());
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
            affichage.setContainer("nbBat");
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
            //partie.placerBateauJ1();
            //partie.placerBateauJ2();
            affichage.drawGrille1(partie.j1.maGrille, false);
            affichage.drawGrille2(partie.j2.maGrille, false);
        }
    }
    class ValidNBListen implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            affichage.setContainer("mode");
            partie.nbBateau = affichage.getComboBoxNbBat();
        }
    }
    class ListenForBateauJ1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(partie.J1doitplacerBat()){
            JButton parent = (JButton)e.getSource();
            affichage.setSelectBateau((Bateau) parent);
            }
        }
    }
    class ListenForBateauJ2 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(partie.J2doitplacerBat()){
                JButton parent = (JButton)e.getSource();
                affichage.setSelectBateau((Bateau) parent);
            }
        }
    }


    class ListenForPlacement implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (partie.J1doitplacerBat()){
                partie.setJ1doitplacerBat(false);
            partie.setJ2doitplacetBat(true);
            affichage.drawGrille1(partie.j1.maGrille, true);
        }else if(partie.J2doitplacerBat()){
                System.out.println("c'est l'heure du DUELLLLLLLL");
                partie.setJ2doitplacetBat(false);
                partie.setJ1DoitTirer(true);
                JButton parent = (JButton)e.getSource();
                parent.setVisible(false);
                affichage.drawGrille2(partie.j2.maGrille, true);
            }
        }
    }


    public class ListenForMouse implements MouseListener {

        // Called when a mouse button is clicked

        public void mouseClicked(MouseEvent e) {
            cellule parent = (cellule)e.getSource();
//            System.out.println("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");

            //System.out.println("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
//            System.out.println(parent.getx() + " " + parent.gety());
//            System.out.println("Mouse Button: " + e.getButton()  + "\n");
            if (parent.getAppartient().equals("j1")){
//                System.out.println(partie.J1doitplacerBat() + " "+affichage.getSelectBateau().getText());
                if(partie.J1doitplacerBat() && affichage.getSelectBateau()!= null){
                    Boolean sens = affichage.getSelectBateau().getSens();
                    String nomBat = affichage.getSelectBateau().getText();
                    Position pos = new Position(parent.getx(), parent.gety(), sens);
                    partie.j1.setBateauplacer(nomBat, pos);
                    affichage.drawGrille1(partie.j1.maGrille, false);
                }
//                System.out.println("Grille1");
                if(partie.getJ1DoitTirer()) {
                    partie.j1.getShot(parent.getx() + 1, parent.gety() + 1);
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    partie.setJ1DoitTirer(false);
                    partie.setJ2DoitTirer(true);
                }
            }else{
//                System.out.println(partie.J2doitplacerBat() + " "+affichage.getSelectBateau().getText());
                if(partie.J2doitplacerBat() && affichage.getSelectBateau()!= null){
                    Boolean sens = affichage.getSelectBateau().getSens();
                    String nomBat = affichage.getSelectBateau().getText();
                    Position pos = new Position(parent.getx(), parent.gety(), sens);
                    partie.j2.setBateauplacer(nomBat, pos);
                    affichage.drawGrille2(partie.j2.maGrille, false);
                }
//                System.out.println("Grille2");
                if(partie.getJ2DoitTirer()) {
                    partie.j2.getShot(parent.getx() + 1, parent.gety() + 1);
                    affichage.drawGrille2(partie.j2.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    partie.setJ1DoitTirer(true);
                    partie.setJ2DoitTirer(false);
                }
            }

            // System.out.println("Mouse Clicks: " + e.getClickCount()  + "\n");

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

