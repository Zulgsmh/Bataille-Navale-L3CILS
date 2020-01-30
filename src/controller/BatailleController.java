package controller;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        this.affichage.addRandomBateauListener(new ListenForRandomBateau());
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
            affichage.setContainer("plateau");
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
                partie.setJ2doitplacetBat(false);
                affichage.getRandomButton().setVisible(false);
                partie.setJ1DoitTirer(true);
                JButton parent = (JButton)e.getSource();
                parent.setVisible(false);
                affichage.drawGrille2(partie.j2.maGrille, true);
                affichage.drawGrille1(partie.j1.maGrille, false);
            }
        }
    }

    // placer les bateau aléatoirement :
    class ListenForRandomBateau implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int nb = partie.getNbBateau();
            if (partie.J1doitplacerBat()) {
                //vider la grille
                for( int i =0 ; i < partie.j1.getListNavire().length ; i++ ){
                    partie.j1.setListNavire(i);
                    partie.j1.listNavire[i].setEstPose(false);
                }

                // partie.j1.initMaGrille();
                partie.j1.initListeBateauPosable();
                partie.j1.placerBateau(nb, true);
                affichage.drawGrille1(partie.j1.maGrille, false);
            }
            else if (partie.J2doitplacerBat()) {
                for( int i =0 ; i < partie.j2.getListNavire().length ; i++ ){
                    partie.j2.setListNavire(i);
                }
                // partie.j2.initMaGrille();
                partie.j2.initListeBateauPosable();
                partie.j2.placerBateau(nb, true);
                affichage.drawGrille2(partie.j2.maGrille, false);
            }
        }
    }


    public class ListenForMouse implements MouseListener {
        Color violet = new Color(110,74,227);
        Color violetF = new Color(42,0,51);
        // Called when a mouse button is clicked

        public void mouseClicked(MouseEvent e) {
            Cellule parent = (Cellule)e.getSource();
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
                if(partie.getJ2DoitTirer()) {
                    for(int i =0 ; i< partie.j1.getListNavire().length ; i++){
                        if(partie.j1.getListNavire()[i].getEstPose()) {
                            System.out.println(partie.j1.getListNavire()[i].getNom());
                            System.out.println(partie.j1.getListNavire()[i].getVie());

                        }
                    }//Boîte du message d'information
                    if(partie.j1.getShot(parent.getx() + 1, parent.gety() + 1)){
                        affichage.setAfficherPopUpVictoire("J2");
                    }
                    affichage.drawGrille2(partie.j2.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, false);
                    partie.setJ1DoitTirer(true);
                    partie.setJ2DoitTirer(false);
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
                if(partie.getJ1DoitTirer()) {
                    for(int i =0 ; i< partie.j2.getListNavire().length ; i++){
                        if(partie.j2.getListNavire()[i].getEstPose()) {
                            System.out.println(partie.j2.getListNavire()[i].getNom());
                            System.out.println(partie.j2.getListNavire()[i].getVie());
                            //Boîte du message d'information
                        }
                    }
                    if(partie.j2.getShot(parent.getx() + 1, parent.gety() + 1)) {
                        affichage.setAfficherPopUpVictoire("J1");
                    }
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    affichage.drawGrille2(partie.j2.maGrille, false);
                    partie.setJ1DoitTirer(false);
                    partie.setJ2DoitTirer(true);
                }
            }

            // System.out.println("Mouse Clicks: " + e.getClickCount()  + "\n");

        }

        // Called when the mouse enters the component assigned

        // the MouseListener

        public void mouseEntered(MouseEvent e) {
            Color violet = new Color(110,74,227);
            Color violetF = new Color(42,0,51);
            Cellule parent = (Cellule)e.getSource();
            if (parent.getBackground().equals(violet)) {
                boolean ciblerj2  = parent.getAppartient().equals("j2") && partie.getJ1DoitTirer();
                boolean ciblerj1 = parent.getAppartient().equals("j1") && partie.getJ2DoitTirer();
                if(ciblerj1 || ciblerj2){
                    parent.setBackground(Color.red);
                }else{ parent.setBackground(Color.gray);}
            }
            //parent.revalidate();
        }
        // Called when the mouse leaves the component assigned
        // the MouseListener

        public void mouseExited(MouseEvent e) {
            JPanel parent = (JPanel)e.getSource();
            if (parent.getBackground().equals(Color.gray)) {
                parent.setBackground(violet);
            }
            if((partie.getJ1DoitTirer()||partie.getJ2DoitTirer() )&& parent.getBackground().equals(Color.red)){
                parent.setBackground(violet);
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
