package view;
import java.awt.*;
import java.awt.event.ActionListener;
import controller.BatailleController;
import model.Joueur;

import javax.swing.*;



public class Affichage extends JFrame {
    private CardLayout c = new CardLayout();
    private JPanel container = new JPanel();


    //couleurs arrière plan / boutons
    Color violet = new Color(110,74,227);
    Color violetF = new Color(42,0,51);


    private  JOptionPane jop1;

// Tout ce qui est ajouté dans le plateau
    private JPanel plateau = new JPanel();



    private JPanel Grille1 = new JPanel();
    private JPanel Grille2 = new JPanel();
    private JPanel listBateauJ1 = new JPanel();
    private JPanel listBateauJ2 = new JPanel();
    //creation bateau aleatoire:
    private JButton RandomBateau = new JButton();
    private JButton validerPlacementBateau = new JButton();
    private Cellule[][] CelluleGrille1 = new Cellule[10][10];
    private Cellule[][] CelluleGrille2 = new Cellule[10][10];
    private Bateau[] buttonBateauJ1 = new Bateau[10];
    private Bateau[] buttonBateauJ2 = new Bateau[10];
    private String[] bateauName = {"PorteAvion", "SousMarin", "CuirasséFurtif1", "CuirasséFurtif2","Zodiac"};
    private Bateau bateauSelect = new Bateau("", true);
    private Boolean sens = false;
//info tour joueur
    private JLabel infoTourJoueur = new JLabel();
    private JLabel infoRadarJoueur = new JLabel("...",SwingConstants.CENTER);




    public Affichage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500,600);
        container.setLayout(c);
        this.setUndecorated(true);


        //*******************  Plateau de JEu ********************

        plateau.setBackground(violetF);

        //définition de la grille1
        Grille1.setBackground(Color.black);
        Grille1.setPreferredSize( new Dimension( 400, 400 ) );
        Grille1.setLayout(new GridLayout(10,10));
        for(int j = 0; j < 10; j++){
            for(int i = 0; i < 10; i++){
                CelluleGrille1[i][j] = new Cellule(i, j, "j1");
                CelluleGrille1[i][j].setBorder(BorderFactory.createLineBorder(Color.black));

                Grille1.add(CelluleGrille1[i][j]);
            }
        }
        //définition de la grille2
        Grille2.setBackground(Color.BLUE);
        Grille2.setPreferredSize( new Dimension( 400, 400 ) );
        Grille2.setLayout(new GridLayout(10,10));
        for(int j = 0; j < 10; j++){
            for(int i = 0; i < 10; i++){
                CelluleGrille2[i][j] = new Cellule(i, j, "j2");
                CelluleGrille2[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                Grille2.add(CelluleGrille2[i][j]);
            }
        }



        listBateauJ1.setPreferredSize( new Dimension( 300, 500 ) );
        for (int i = 0;i<10;i++) {
            Boolean vertical;
            if(i%2==0){
                vertical = true;
            }else{
                vertical = false;
            }
            buttonBateauJ1[i] = new Bateau ("j1",vertical);
            buttonBateauJ1[i].setText(bateauName[(int)(i/2)]);
            buttonBateauJ1[i].setBackground(violet);
            buttonBateauJ1[i].setForeground(Color.white);
            buttonBateauJ1[i].setFocusable(false);
            buttonBateauJ1[i].setFocusPainted(false);
            buttonBateauJ1[i].setBorderPainted(false);
            buttonBateauJ1[i].setFont(new Font("Arial Black",Font.PLAIN, 26));
            
            listBateauJ1.add(buttonBateauJ1[i]);
        }


        listBateauJ1.setBackground(violetF);



        listBateauJ2.setBackground(violetF);
        listBateauJ2.setPreferredSize( new Dimension( 300, 500 ) );
        for (int i = 0;i<10;i++) {
            Boolean vertical;
            if(i%2==0){
                vertical = true;
            }else{
                vertical = false;
            }
            buttonBateauJ2[i] = new Bateau ("j2",vertical);
            buttonBateauJ2[i].setText(bateauName[(int)(i/2)]);
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
        infoTourJoueur.setPreferredSize(new Dimension(300,100));
        infoTourJoueur.setText("J1 doit placer ses bateau");
        infoTourJoueur.setForeground(Color.white);

        infoRadarJoueur.setBackground(new Color(81,255,0));
        infoRadarJoueur.setPreferredSize(new Dimension(300,100));
        infoRadarJoueur.setForeground(Color.white);



        plateau.add(listBateauJ1);
        plateau.add(Grille1);
        plateau.add(Grille2);
        plateau.add(listBateauJ2);
        //info sur qui joue
        plateau.add(infoTourJoueur);
        plateau.add(validerPlacementBateau);
        //ajout du boutton bateau random au plateau
        plateau.add(RandomBateau);
        plateau.add(infoRadarJoueur);


        //******************           CardLayout           ****************
//        container.add(Menu, "menu");
//        container.add(NombreBateau, "nbBat");
//        container.add(Mode, "mode");
        container.add(plateau, "plateau");
        c.show(container, "plateau");
        this.add(container);
        System.setProperty("marron", "0XA95B23");
        System.setProperty("orange", "0XFA5C00");

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
        jop1.showMessageDialog(null, "Victoire de " + gagnant , "Information",
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
        for (int i = 0; i < 10; i++){
            for (int j=0; j < 10; j++) {
                CelluleGrille2[i][j].setNom(maGrille[i][j]);
                if (maGrille[i][j] == null) {
                    CelluleGrille2[i][j].setColor(violet);
                } else if (maGrille[i][j].equals("PLOF")) {
                    CelluleGrille2[i][j].setColor(Color.black);
                } else if (maGrille[i][j].equals("SHOT")) {
                    CelluleGrille2[i][j].setColor(Color.getColor("orange"));
                }else if (!hide) {
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
                }else{CelluleGrille2[i][j].setColor(violet);}
            }
        }
    }

}
