package controller;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class BatailleController {

    private Affichage affichage;
    private Partie partie;

    public BatailleController(Affichage affichage, Partie partie){
        this.affichage = affichage;
        this.partie = partie;

        //*****************          Plateau           *****************
        this.affichage.addGrille1Listener(new ListenForMouse());
        this.affichage.addGrille2Listener(new ListenForMouse());
        this.affichage.addlistBateauJ1Listener(new ListenForBateauJ1(), new ListenForMouseBateau());
        this.affichage.addlistBateauJ2Listener(new ListenForBateauJ2(), new ListenForMouseBateau());
        this.affichage.addvaliderPlacementListener(new ListenForPlacement());
        this.affichage.addRandomBateauListener(new ListenForRandomBateau());
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
                affichage.drawGrille1(partie.j1.maGrille, true);
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
                System.out.println("j2 doit placer ses bateau : "+nb);
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
            if (parent.getAppartient().equals("j1")){
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
                    if(partie.j1.getShot(parent.getx() + 1, parent.gety() + 1, partie.getTypeRadar())[0]){
                        affichage.setAfficherPopUpVictoire("J2");
                    }
                    affichage.drawGrille2(partie.j2.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, true);
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
                    if(partie.j2.getShot(parent.getx() + 1, parent.gety() + 1, partie.getTypeRadar())[0]) {
                        affichage.setAfficherPopUpVictoire("J1");
                    }
                    if(partie.j2.getEstOrdi()){
                        System.out.println("j2 est un ordi");
                        Thread t = new Thread() {
                            public void run() {
                                try
                                {
                                    partie.setJ1DoitTirer(false);
                                    Thread.sleep(500);
                                    if(partie.ordiMove(partie.j1)){
                                        affichage.drawGrille1(partie.j1.maGrille, true);
                                        affichage.drawGrille2(partie.j2.maGrille, true);
                                        affichage.setAfficherPopUpVictoire("de l'ordi");
                                    }
                                    affichage.drawGrille1(partie.j1.maGrille, true);
                                    affichage.drawGrille2(partie.j2.maGrille, true);
                                    partie.setJ1DoitTirer(true);
                                }
                                catch(InterruptedException ex)
                                {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        };
                        t.start();
                    }else {
                        partie.setJ1DoitTirer(false);
                        partie.setJ2DoitTirer(true);
                    }
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    affichage.drawGrille2(partie.j2.maGrille, true);
                }
            }
        }

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
        }

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
    public class ListenForMouseBateau implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }


        public void mouseEntered(MouseEvent e) {
            Bateau parent = (Bateau)e.getSource();
            parent.setBackground(Color.white);
            parent.setForeground(Color.black);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Bateau parent = (Bateau)e.getSource();
            parent.setBackground(new  Color(110,74,227));
            parent.setForeground(Color.white);
        }
    }
}
