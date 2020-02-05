package view.plateau;
import java.awt.*;
import java.awt.event.ActionListener;
import controller.BatailleController;
import view.Menu1;

import javax.swing.*;



public class Affichage extends JFrame {
    private final CardLayout c = new CardLayout();
    private final JPanel container = new JPanel();


    //couleurs arrière plan / boutons
    private final Color violet = new Color(110,74,227);
    private int size = 26;

    private  JOptionPane jop1;


    //creation bateau aleatoire:
    private final JButton RandomBateau = new JButton();
    private final JButton validerPlacementBateau = new JButton();
    private final Cellule[][] CelluleGrille1 = new Cellule[10][10];
    private final Cellule[][] CelluleGrille2 = new Cellule[10][10];
    private static final Bateau[] buttonBateauJ1 = new Bateau[10];
    private final Bateau[] buttonBateauJ2 = new Bateau[10];
    private Bateau bateauSelect = new Bateau("", true);
    private Boolean sens = false;
//info tour joueur
    private final JLabel infoTourJoueur = new JLabel();
    private final JLabel infoRadarJoueur = new JLabel("...",SwingConstants.CENTER);
    public static final JLabel infoDemo = new JLabel();


    private boolean demo;



    public Affichage(boolean demo){






        this.demo = demo;
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500,600);
        this.setLocationRelativeTo(null);

        container.setLayout(c);





        //*******************  Plateau de JEu ********************

        // Tout ce qui est ajouté dans le plateau
        JPanel plateau = new JPanel();
        Color violetF = new Color(42, 0, 51);
        plateau.setBackground(violetF);

        //définition de la grille1
        JPanel grille1 = new JPanel();
        grille1.setBackground(Color.black);
        grille1.setPreferredSize( new Dimension( 400, 400 ) );
        grille1.setLayout(new GridLayout(10,10));
        for(int j = 0; j < 10; j++){
            for(int i = 0; i < 10; i++){
                CelluleGrille1[i][j] = new Cellule(i, j, "j1");
                CelluleGrille1[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                grille1.add(CelluleGrille1[i][j]);
            }
        }
        //définition de la grille2
        JPanel grille2 = new JPanel();
        grille2.setBackground(Color.BLUE);
        grille2.setPreferredSize( new Dimension( 400, 400 ) );
        grille2.setLayout(new GridLayout(10,10));
        for(int j = 0; j < 10; j++){
            for(int i = 0; i < 10; i++){
                CelluleGrille2[i][j] = new Cellule(i, j, "j2");
                CelluleGrille2[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                grille2.add(CelluleGrille2[i][j]);
            }
        }


        JPanel listBateauJ1 = new JPanel();
        listBateauJ1.setPreferredSize( new Dimension( 300, 500 ) );
        String[] bateauName = {"PorteAvion", "SousMarin", "CuirasséFurtif1", "CuirasséFurtif2", "Zodiac"};

        for (int i = 0; i<10; i++) {
            Boolean vertical;
            vertical = i % 2 == 0;
            buttonBateauJ1[i] = new Bateau ("j1",vertical);
            buttonBateauJ1[i].setText(bateauName[i/2]);
            buttonBateauJ1[i].setBackground(violet);
            buttonBateauJ1[i].setForeground(Color.white);
            buttonBateauJ1[i].setFocusable(false);
            buttonBateauJ1[i].setFocusPainted(false);
            buttonBateauJ1[i].setBorderPainted(false);
            buttonBateauJ1[i].setFont(new Font("Arial Black",Font.PLAIN, 26));
            
            listBateauJ1.add(buttonBateauJ1[i]);
        }


        listBateauJ1.setBackground(violetF);
        JPanel listBateauJ2 = new JPanel();
        listBateauJ2.setBackground(violetF);
        listBateauJ2.setPreferredSize( new Dimension( 300, 500 ) );

        for (int i = 0;i<10;i++) {
            Boolean vertical;
            vertical = i % 2 == 0;
            buttonBateauJ2[i] = new Bateau ("j2",vertical);
            buttonBateauJ2[i].setText(bateauName[i/2]);
            buttonBateauJ2[i].setBackground(violet);
            buttonBateauJ2[i].setForeground(Color.white);
            buttonBateauJ2[i].setFocusable(false);
            buttonBateauJ2[i].setFocusPainted(false);
            buttonBateauJ2[i].setBorderPainted(false);
            buttonBateauJ2[i].setFont(new Font("Arial Black",Font.PLAIN, 26));
            listBateauJ2.add(buttonBateauJ2[i]);
        }

        listBateauJ1.setLayout(new FlowLayout(FlowLayout.CENTER));
        listBateauJ2.setLayout(new FlowLayout(FlowLayout.CENTER));




        validerPlacementBateau.setBackground(new Color(31,160,85));
        validerPlacementBateau.setPreferredSize(new Dimension(200,100));
        validerPlacementBateau.setText("VALIDER");

        //Bouton bateau aleatoire:
        RandomBateau.setBackground(new Color(139,0,0));
        RandomBateau.setPreferredSize(new Dimension(200,100));
        RandomBateau.setText("Bateau aléatoire");




        infoTourJoueur.setBackground(new Color(81,255,0));
        infoTourJoueur.setPreferredSize(new Dimension(500,100));
        infoTourJoueur.setText("J1 doit placer ses bateau");
        infoTourJoueur.setForeground(Color.white);
        Font f = new Font("Arial Black", Font.PLAIN, 26);
        infoTourJoueur.setFont(f);

        infoRadarJoueur.setBackground(new Color(81,255,0));
        infoRadarJoueur.setPreferredSize(new Dimension(500,100));
        infoRadarJoueur.setForeground(Color.white);
        infoRadarJoueur.setFont(f);

        plateau.add(listBateauJ1);
        plateau.add(grille1);
        plateau.add(grille2);
        plateau.add(listBateauJ2);
        //info sur qui joue
        plateau.add(infoTourJoueur);
        plateau.add(validerPlacementBateau);
        //ajout du boutton bateau random au plateau
        plateau.add(RandomBateau);
        plateau.add(infoRadarJoueur);


        //******************           CardLayout           ****************

        container.add(plateau, "plateau");
        c.show(container, "plateau");
        this.add(container);
        System.setProperty("marron", "0XA95B23");
        System.setProperty("orange", "0XFA5C00");




        //*******************  Partie Demo ********************



        if(this.demo == true) {
            validerPlacementBateau.setVisible(false);
            RandomBateau.setVisible(false);

            buttonBateauJ1[0].setVisible(false);
            buttonBateauJ2[0].setVisible(false);
            buttonBateauJ1[1].setVisible(false);
            buttonBateauJ2[1].setVisible(false);
            buttonBateauJ1[2].setVisible(false);
            buttonBateauJ2[2].setVisible(false);
            buttonBateauJ1[3].setVisible(false);
            buttonBateauJ2[3].setVisible(false);
            buttonBateauJ1[4].setVisible(false);
            buttonBateauJ2[4].setVisible(false);
            buttonBateauJ1[5].setVisible(false);
            buttonBateauJ2[5].setVisible(false);
            buttonBateauJ1[6].setVisible(false);
            buttonBateauJ2[6].setVisible(false);
            buttonBateauJ1[7].setVisible(false);
            buttonBateauJ2[7].setVisible(false);
            buttonBateauJ1[8].setVisible(false);
            buttonBateauJ2[8].setVisible(false);
            buttonBateauJ1[9].setVisible(false);
            buttonBateauJ2[9].setVisible(false);
            infoRadarJoueur.setVisible(false);
            infoTourJoueur.setVisible(false);

            infoDemo.setFont(f);
            infoDemo.setForeground(Color.white);
            plateau.add(infoDemo);
            BatailleController.demoNext mml = new BatailleController.demoNext();
            container.addMouseListener(mml);
            plateau.addMouseListener(mml);
        }

    }
    public void setContainer(String card){
        c.show(container, card);
    }

    public void setSelectBateau(Bateau bat){
        this.bateauSelect = bat;
    }
    public Bateau getSelectBateau(){
        return this.bateauSelect;
    }
    public JButton getRandomButton(){ return this.RandomBateau ; }

    public void setAfficherPopUpVictoire(String gagnant){
        jop1 = new JOptionPane() ;
        JOptionPane.showMessageDialog(null, "Victoire de " + gagnant , "Information",
                JOptionPane.INFORMATION_MESSAGE);
        // Récupérer les frames et les fermer TODO
        RevenirMenu();
    }

    //Fonction changer de page après fin de partie
    public void RevenirMenu(){
        dispose();
        Menu1 t1 = new Menu1();
    }

    public JOptionPane getAfficherPopUpVictoire(){ return this.jop1 ; }


    public void addGrille1Listener(BatailleController.ListenForMouse lForMouse){
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille1[i][j].addMouseListener(lForMouse);
            }
        }
    }
    public void addGrille2Listener(BatailleController.ListenForMouse lForMouse){
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille2[i][j].addMouseListener(lForMouse);
            }
        }
    }
    public void addlistBateauJ1Listener(ActionListener ListenForBateauJ1, BatailleController.ListenForMouseBateau lForMouse){
        for(int i = 0; i < 10; i++){
            buttonBateauJ1[i].addActionListener(ListenForBateauJ1);
            buttonBateauJ1[i].addMouseListener(lForMouse);
        }
    }
    public void addlistBateauJ2Listener(ActionListener ListenForBateauJ2, BatailleController.ListenForMouseBateau lForMouse){
        for(int i = 0; i < 10; i++){
            buttonBateauJ2[i].addActionListener(ListenForBateauJ2);
            buttonBateauJ2[i].addMouseListener(lForMouse);
        }
    }

    public void addvaliderPlacementListener(ActionListener ListenForPlacement){
        validerPlacementBateau.addActionListener(ListenForPlacement);
    }

    public void addRandomBateauListener(ActionListener ListenForRandomBateau){
        RandomBateau.addActionListener(ListenForRandomBateau);
    }
    public void setInfoTourJoueur(String text){
        infoTourJoueur.setText(text);
    }
    public void setInfoRadarJoueur(String text){
        infoRadarJoueur.setText(text);
    }


    public void drawGrille1(String[][] maGrille, boolean hide){
        for (int i = 0; i < 10; i++){
            for (int j=0; j < 10; j++){
                CelluleGrille1[i][j].setNom(maGrille[i][j]);
                if(maGrille[i][j] == null){
                    CelluleGrille1[i][j].setColor(violet);
                }else if(maGrille[i][j].equals("PLOF")){
                    CelluleGrille1[i][j].setColor(Color.black);
                }else if(maGrille[i][j].equals("SHOT")){
                    CelluleGrille1[i][j].setColor(Color.getColor("orange"));
                }else if (!hide) {
                    if(maGrille[i][j].equals("PORT")){
                        CelluleGrille1[i][j].setColor(Color.getColor("marron"));
                    }else if(maGrille[i][j].equals("SOUS")){
                        CelluleGrille1[i][j].setColor(Color.yellow);
                    }else if(maGrille[i][j].equals("CUI1")){
                        CelluleGrille1[i][j].setColor(Color.pink);
                    }else if(maGrille[i][j].equals("CUI2")){
                        CelluleGrille1[i][j].setColor(Color.MAGENTA);
                    }else if(maGrille[i][j].equals("ZODI")){
                        CelluleGrille1[i][j].setColor(Color.green);
                    }
                }else{CelluleGrille1[i][j].setColor(violet);}
            }
        }
    }
    public void drawGrille2(String[][] maGrille, boolean hide){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille2[i][j].setNom(maGrille[i][j]);
                if (CelluleGrille2[i][j].getBackground() != Color.cyan) {
                    if (maGrille[i][j] == null) {
                        CelluleGrille2[i][j].setColor(violet);
                    } else if (maGrille[i][j].equals("PLOF")) {
                        CelluleGrille2[i][j].setColor(Color.black);
                    } else if (maGrille[i][j].equals("SHOT")) {
                        CelluleGrille2[i][j].setColor(Color.getColor("orange"));
                    } else if (!hide) {
                        if (maGrille[i][j].equals("PORT")) {
                            CelluleGrille2[i][j].setColor(Color.getColor("marron"));
                        } else if (maGrille[i][j].equals("SOUS")) {
                            CelluleGrille2[i][j].setColor(Color.yellow);
                        } else if (maGrille[i][j].equals("CUI1")) {
                            CelluleGrille2[i][j].setColor(Color.pink);
                        } else if (maGrille[i][j].equals("CUI2")) {
                            CelluleGrille2[i][j].setColor(Color.MAGENTA);
                        } else if (maGrille[i][j].equals("ZODI")) {
                            CelluleGrille2[i][j].setColor(Color.green);
                        }
                    } else {
                        CelluleGrille2[i][j].setColor(violet);
                    }
                }
            }
        }
    }



    public void radar(int tirX, int tirY, int dist, Color c) {

        for(int x = tirX-dist; x <= tirX+dist; x++){
            for(int y = tirY-dist; y <= tirY+dist; y++){
                if (x >= 0 && x < 10 && y >= 0 && y < 10 && dist != 0) {
                        CelluleGrille2[x][y].setColor(c);
                }
            }
        }
    }

    public static void demo(int nbClick){

        if(nbClick == 0){
            infoDemo.setText("BIENVENUE DANS LA DEMO DU JEUX");
        } else if (nbClick == 1) {
            infoDemo.setText("VOICI LES DEUX GRILLES SUR LESQUELS VOUS ALLEZ PLACER VOS BATEAUX");
        } else if (nbClick == 2) {
            infoDemo.setText("POUR PLACER VOS BATEAUX APPUYER SUR CE BOUTON ET CLIQUER SUR LA GRILLE DE GAUCHE");
            buttonBateauJ1[0].setVisible(true);
        }else if (nbClick == 3) {
            infoDemo.setText("BRAVO ! VOUS VENEZ DE PLACER VOTRE PORTE AVION !");
        }else if (nbClick == 4) {
            infoDemo.setText("POUR LE PLACER HORIZONTALEMENT CLIQUER SUR LE BOUTON JUSTE EN DESSOUS");
            buttonBateauJ1[0].setVisible(false);
            buttonBateauJ1[1].setVisible(true);
            

        }

    }

}