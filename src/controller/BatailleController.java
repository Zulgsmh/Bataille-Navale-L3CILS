package controller;

import model.Partie;
import model.Position;
import view.plateau.Affichage;
import view.plateau.Bateau;
import view.plateau.Cellule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BatailleController {

    private final Affichage affichage;
    private final Partie partie;
    public final Color violet = new Color(110,74,227);
    public Color violetF = new Color(42,0,51);

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
        this.affichage.addDemoListener(new demoNext());
        this.affichage.addartillerieListener(new ListenForArtiellerie());
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
    public class demoNext implements MouseListener {
        private int nbClick = 0;
        @Override
        public void mouseClicked(MouseEvent arg0) {

            nbClick++;
            affichage.demo(nbClick);



        }

        @Override
        public void mouseEntered(MouseEvent arg0) { }

        @Override
        public void mouseExited(MouseEvent arg0) { }

        @Override
        public void mousePressed(MouseEvent arg0) { }

        @Override
        public void mouseReleased(MouseEvent arg0) { }
    }
    class ListenForPlacement implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (affichage.getDemo()) {
                if(partie.J1doitplacerBat()){
                    partie.setJ2doitplacetBat(true);
                    partie.setJ1doitplacerBat(false);

                } else if (partie.J2doitplacerBat()) {
                    partie.setJ2doitplacetBat(false);
                    partie.setJ1doitplacerBat(false);
                    partie.setJ1DoitTirer(true);
                    affichage.drawGrille2(partie.j2.maGrille,true);
                }
            } else {
                if (partie.J1doitplacerBat()) {
                    if (partie.j2.getEstOrdi()) {
                        int nb = partie.getNbBateau();
                        for (int i = 0; i < partie.j2.getListNavire().length; i++) {
                            partie.j2.setListNavire(i);
                        }
                        // partie.j2.initMaGrille();
                        System.out.println("j2 doit placer ses bateau : " + nb);
                        partie.j2.initListeBateauPosable();
                        partie.j2.placerBateau(nb);
                        affichage.drawGrille2(partie.j2.maGrille, true);
                        partie.setJ2doitplacetBat(false);
                        partie.setJ1doitplacerBat(false);
                        partie.setJ1DoitTirer(true);
                        affichage.setValiderPlacementBateau(false);
                        affichage.setRandomBateau(false);


                    } else {
                        partie.setJ1doitplacerBat(false);
                        partie.setJ2doitplacetBat(true);
                        affichage.drawGrille1(partie.j1.maGrille, true);
                        affichage.setInfoTourJoueur("J2 doit placer ses bateaux");
                    }
                } else if (partie.J2doitplacerBat()) {
                    partie.setJ2doitplacetBat(false);
                    affichage.getRandomButton().setVisible(false);
                    partie.setJ1DoitTirer(true);
                    JButton parent = (JButton) e.getSource();
                    parent.setVisible(false);
                    affichage.drawGrille2(partie.j2.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    affichage.setInfoTourJoueur("J1 doit tirer");

                }
            }
        }
    }
    public void baisageDeDaronne(int i,Boolean vecteur) {

        if(partie.getJ1DoitTirer()){

            if (partie.j1.getEtat0()) {
                System.out.println("dans état 0");
                int x = 0;
                affichage.drawGrille2(partie.j2.maGrille,true);
                affichage.getCelluleGrille2()[x][i].setBackground(Color.red);

                if(i>8) {
                    vecteur = false;
                }
                if(i<1){
                    vecteur=true;
                }
                if (!vecteur) {
                    partie.j1.setPoseXarti(i);
                    setTimeout(() -> baisageDeDaronne(i - 1, false), 200);
                }
                else{
                    partie.j1.setPoseXarti(i);
                    setTimeout(()->baisageDeDaronne(i+1,true),200);
                }
            }
            else if (partie.j1.getEtat1()) {

                int y = 0;
                affichage.drawGrille2(partie.j2.maGrille,true);
                affichage.getCelluleGrille2()[i][partie.j1.getPoseXarti()].setBackground(Color.red);

                if(i>8) {
                    vecteur = false;
                }
                if(i<1){
                    vecteur=true;
                }
                if (!vecteur) {
                    partie.j1.setPoseYarti(i);
                    setTimeout(() -> baisageDeDaronne(i - 1, false), 200);
                }
                else{
                    partie.j1.setPoseYarti(i);
                    setTimeout(()->baisageDeDaronne(i+1,true),200);
                }
            }
            else if(partie.j1.getEtat2()){
                partie.setJ1DoitTirer(false);
                partie.setJ2DoitTirer(true);

                partie.j2.getShot(partie.j1.getPoseYarti()+1,partie.j1.getPoseXarti()+1,true);
                //affichage.drawGrille2(partie.j2.maGrille,true);
                if(partie.getTypeAR()){
                    System.out.println(partie.j2.getRadar());
                    System.out.println("POS : "+partie.j1.getPoseYarti() +"  "+partie.j1.getPoseXarti());
                    System.out.println("BOUTON : "+affichage.getCelluleGrille2()[partie.j1.getPoseYarti()][partie.j1.getPoseXarti()]);
                    vague(affichage.getCelluleGrille2()[partie.j1.getPoseYarti()][partie.j1.getPoseXarti()], 0, true);
                }
                partie.j1.setEtatStart(false);
                partie.j2.setEtatStart(true);
            }
        }
        else if(partie.getJ2DoitTirer()){
            if (partie.j2.getEtat0()) {

                int x = 0;
                affichage.drawGrille1(partie.j1.maGrille,true);
                affichage.getCelluleGrille1()[x][i].setBackground(Color.red);

                if(i>8) {
                    vecteur = false;
                }
                if(i<1){
                    vecteur=true;
                }
                if (!vecteur) {
                    partie.j2.setPoseXarti(i);
                    setTimeout(() -> baisageDeDaronne(i - 1, false), 200);
                }
                else{
                    partie.j2.setPoseXarti(i);
                    setTimeout(()->baisageDeDaronne(i+1,true),200);
                }
            }
            else if (partie.j2.getEtat1()) {

                int y = 0;
                affichage.drawGrille1(partie.j1.maGrille,true);
                affichage.getCelluleGrille1()[i][partie.j2.getPoseXarti()].setBackground(Color.red);

                if(i>8) {
                    vecteur = false;
                }
                if(i<1){
                    vecteur=true;
                }
                if (!vecteur) {
                    partie.j2.setPoseYarti(i);
                    setTimeout(() -> baisageDeDaronne(i - 1, false), 200);
                }
                else{
                    partie.j2.setPoseYarti(i);
                    setTimeout(()->baisageDeDaronne(i+1,true),200);
                }
            }
            else if(partie.j2.getEtat2()){
                System.out.println("dans etat2 ");
                partie.setJ1DoitTirer(true);
                partie.setJ2DoitTirer(false);
                partie.j2.setEtatStart(false);
                partie.j1.setEtatStart(true);
                partie.j1.getShot(partie.j2.getPoseYarti()+1,partie.j2.getPoseXarti()+1,true);
                if(partie.getTypeAR()){
                    vague(affichage.getCelluleGrille1()[partie.j2.getPoseYarti()][partie.j2.getPoseXarti()], 0, false);
                }
                affichage.drawGrille1(partie.j1.maGrille,true);
            }

        }
    }
    public void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    class ListenForArtiellerie implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            if(partie.j1.getEtatStart()) {
                System.out.println("DANS JE QUI TIRE");
                partie.j1.setPoseXarti(0);
                partie.j1.setPoseYarti(0);
                partie.j1.setEtat0(true);
                partie.j1.setEtat1(false);
                partie.j1.setEtat2(false);
                partie.j1.setEtatStart(false);
                baisageDeDaronne(0,true);
            }
            else if(partie.j1.getEtat0()){
                partie.j1.setEtat1(true);
                partie.j1.setEtat0(false);
                partie.j1.setEtat2(false);
                partie.j1.setEtatStart(false);
            }
            else if(partie.j1.getEtat1()){
                partie.j1.setEtat1(false);
                partie.j1.setEtat0(false);
                partie.j1.setEtat2(true);
                partie.j1.setEtatStart(false);
            }
            else if (partie.j1.getEtat2()){
                partie.j1.setEtat1(false);
                partie.j1.setEtat0(false);
                partie.j1.setEtat2(false);
            }else if(partie.j2.getEstOrdi()){
                partie.j1.setEtatStart(true);
                partie.j2.setEtatStart(false);
                partie.j2.setEtat1(false);
                partie.j2.setEtat0(false);
                partie.j2.setEtat2(false);
                partie.j1.setEtat0(false);
                partie.j1.setEtat1(false);
                partie.j1.setEtat2(false);
                System.out.println("j2 est un ordi");
                Thread t = new Thread() {
                    public void run() {
                        try {
                            partie.setJ1DoitTirer(false);
                            Thread.sleep(500);
                            if (partie.ordiMove(partie.j1)) {
                                affichage.drawGrille1(partie.j1.maGrille, true);
                                affichage.drawGrille2(partie.j2.maGrille, true);
                                affichage.setAfficherPopUpVictoire("l'ordi");
                            }
                            affichage.drawGrille1(partie.j1.maGrille, true);
                            affichage.drawGrille2(partie.j2.maGrille, true);


                            partie.setJ1DoitTirer(true);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                };
                t.start();
            }else if(partie.j2.getEtatStart()) {
                partie.j2.setPoseXarti(0);
                partie.j2.setPoseYarti(0);
                partie.j2.setEtat0(true);
                partie.j2.setEtat1(false);
                partie.j2.setEtat2(false);
                partie.j2.setEtatStart(false);
                baisageDeDaronne(0,true);
            }
            else if(partie.j2.getEtat0()){
                partie.j2.setEtat1(true);
                partie.j2.setEtat0(false);
                partie.j2.setEtat2(false);
                partie.j2.setEtatStart(false);
            }
            else if(partie.j2.getEtat1()){
                partie.j2.setEtat1(false);
                partie.j2.setEtat0(false);
                partie.j2.setEtat2(true);
                partie.j2.setEtatStart(false);
            }
            else if (partie.j2.getEtat2()){
                partie.j2.setEtat1(false);
                partie.j2.setEtat0(false);
                partie.j2.setEtat2(false);
            }
        }
    }
    //*****************          Bateaux posé aléatoirement           *****************


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
                partie.j1.placerBateau(nb);
                affichage.drawGrille1(partie.j1.maGrille, false);
            }
            else if (partie.J2doitplacerBat()) {
                for( int i =0 ; i < partie.j2.getListNavire().length ; i++ ){
                    partie.j2.setListNavire(i);
                }
                // partie.j2.initMaGrille();
                System.out.println("j2 doit placer ses bateau : "+nb);
                partie.j2.initListeBateauPosable();
                partie.j2.placerBateau(nb);
                affichage.drawGrille2(partie.j2.maGrille, false);
            }
        }
    }

    public class ListenForMouse implements MouseListener {

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
                if(partie.getJ2DoitTirer()) {
                    affichage.setInfoTourJoueur("J1 doit tirer");
                    for(int i =0 ; i< partie.j1.getListNavire().length ; i++){
                        if(partie.j1.getListNavire()[i].getEstPose()) {
                            System.out.println(partie.j1.getListNavire()[i].getNom());
                            System.out.println(partie.j1.getListNavire()[i].getVie());

                        }
                    }//Boîte du message d'information
                    if(partie.j1.getShot(parent.getx() + 1, parent.gety() + 1, partie.getTypeRadar())[0]){
                        affichage.setAfficherPopUpVictoire("J2");
                    }
                    affichage.setInfoRadarJoueur(" Distance d'un bateau : "+partie.j1.getRadar()+" case(s) ");
                    affichage.drawGrille2(partie.j2.maGrille, true);
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    partie.setJ1DoitTirer(true);
                    partie.setJ2DoitTirer(false);


                    int parcour = 0;
                    vague(parent, parcour, false);

                }
            }else{
                if(partie.J2doitplacerBat() && affichage.getSelectBateau()!= null){
                    Boolean sens = affichage.getSelectBateau().getSens();
                    String nomBat = affichage.getSelectBateau().getText();
                    Position pos = new Position(parent.getx(), parent.gety(), sens);
                    partie.j2.setBateauplacer(nomBat, pos);
                    affichage.drawGrille2(partie.j2.maGrille, false);
                }
                if(partie.getJ1DoitTirer()) {
                    affichage.setInfoTourJoueur("J2 doit tirer");
                    for (int i = 0; i < partie.j2.getListNavire().length; i++) {
                        if (partie.j2.getListNavire()[i].getEstPose()) {
                            System.out.println(partie.j2.getListNavire()[i].getNom());
                            System.out.println(partie.j2.getListNavire()[i].getVie());
                            //Boîte du message d'information
                        }
                    }
                    if (partie.j2.getShot(parent.getx() + 1, parent.gety() + 1, partie.getTypeRadar())[0]) {
                        affichage.setAfficherPopUpVictoire("J1");
                    }
                    affichage.setInfoRadarJoueur(" Distance d'un bateau : " + partie.j2.getRadar() + " case(s) ");
                    if (partie.j2.getEstOrdi()) {
                        System.out.println("j2 est un ordi");
                        Thread t = new Thread() {
                            public void run() {
                                try {
                                    partie.setJ1DoitTirer(false);
                                    Thread.sleep(500);
                                    if (partie.ordiMove(partie.j1)) {
                                        affichage.drawGrille1(partie.j1.maGrille, true);
                                        affichage.drawGrille2(partie.j2.maGrille, true);
                                        affichage.setAfficherPopUpVictoire("l'ordi");
                                    }
                                    affichage.drawGrille1(partie.j1.maGrille, true);
                                    affichage.drawGrille2(partie.j2.maGrille, true);


                                    partie.setJ1DoitTirer(true);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        };
                        t.start();
                    } else {
                        partie.setJ1DoitTirer(false);
                        partie.setJ2DoitTirer(true);
                    }
                    affichage.drawGrille1(partie.j1.maGrille, true);
                    affichage.drawGrille2(partie.j2.maGrille, true);


                    //******************           effet de vague dans le mode mission radar           ****************

                        int parcour = 0;
                        vague(parent, parcour, true);


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

    public void vague(Cellule parent, int i, boolean quiTir){
        System.out.println("DANS LA VAGUE getradar :" + partie.j2.getRadar());
        System.out.println(parent.getx()+ " - "+parent.gety());
        affichage.radar(parent.getx(),parent.gety(),i, Color.cyan,quiTir);
        affichage.radar(parent.getx(),parent.gety(),i-1, violet, quiTir);
        affichage.drawGrille1(partie.j1.maGrille, true);
        affichage.drawGrille2(partie.j2.maGrille, true);

        if(quiTir) {
            if (i < partie.j2.getRadar() - 1) {
                setTimeout(() -> vague(parent, i + 1, quiTir), 250);

            }
        } else {
            if (i < partie.j1.getRadar() - 1) {
                setTimeout(() -> vague(parent, i + 1, quiTir), 250);
            }
        }

    }

    //*****************          Style des bouttons du Plateau           *****************

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
