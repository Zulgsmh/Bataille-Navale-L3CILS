package view;
import controller.BatailleController;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Affichage extends JFrame {
    private CardLayout c = new CardLayout();
    private JPanel container = new JPanel();


    private JPanel Menu = new JPanel();

    private JButton jvj = new JButton("JVJ");
    private JButton jvo = new JButton("JVO");
    private JButton ovo = new JButton("OVO");



    private JPanel Mode = new JPanel();

    private JButton classique = new JButton("Classique");
    private JButton radar = new JButton("Radar");
    private JButton artillerie = new JButton("artillerie");
    private JButton coderouge = new JButton("Code Rouge");



    private JPanel NombreBateau = new JPanel();

    private String num[]={"1","2","3","4","5"};
    private JComboBox cb=new JComboBox(num);
    private JButton validNB = new JButton();



    private JPanel plateau = new JPanel();

    private JPanel Grille1 = new JPanel();
    private JPanel Grille2 = new JPanel();
    private JPanel listBateauJ1 = new JPanel();
    private JPanel listBateauJ2 = new JPanel();
    private JButton validerPlacementBateau = new JButton();
    private Cellule[][] CelluleGrille1 = new Cellule[10][10];
    private Cellule[][] CelluleGrille2 = new Cellule[10][10];
    private Bateau[] buttonBateauJ1 = new Bateau[10];
    private Bateau[] buttonBateauJ2 = new Bateau[10];
    private String[] bateauName = {"PorteAvion", "SousMarin", "CuirasséFurtif1", "CuirasséFurtif2","Zodiac"};
    private Bateau bateauSelect = new Bateau("", true);
    private Boolean sens = false;

    public Affichage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,600);
        container.setLayout(c);

        //*******************  MENU  ***********************


        Menu.add(jvj);
        Menu.add(jvo);
        Menu.add(ovo);

        //*******************  MODE *************************


        Mode.add(classique);
        Mode.add(radar);
        Mode.add(artillerie);
        Mode.add(coderouge);

        //*******************  NombreBateau *******************


        cb.setBounds(50, 50,100,400);
        NombreBateau.add(cb);
        NombreBateau.add(validNB);


        //*******************  Plateau de JEu ********************

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

        listBateauJ1.setBackground(Color.GRAY);
        listBateauJ1.setPreferredSize( new Dimension( 150, 400 ) );
        for (int i = 0;i<10;i++) {
            Boolean vertical;
            if(i%2==0){
                vertical = true;
            }else{
                vertical = false;
            }
            buttonBateauJ1[i] = new Bateau ("j1",vertical);
            buttonBateauJ1[i].setText(bateauName[(int)(i/2)]);
            listBateauJ1.add(buttonBateauJ1[i]);
        }
        listBateauJ1.setLayout (new BoxLayout (listBateauJ1, BoxLayout.Y_AXIS));

        listBateauJ2.setBackground(Color.GRAY);
        listBateauJ2.setPreferredSize( new Dimension( 150, 400 ) );
        for (int i = 0;i<10;i++) {
            Boolean vertical;
            if(i%2==0){
                vertical = true;
            }else{
                vertical = false;
            }
            buttonBateauJ2[i] = new Bateau ("j2",vertical);
            buttonBateauJ2[i].setText(bateauName[(int)(i/2)]);
            listBateauJ2.add(buttonBateauJ2[i]);
        }
        listBateauJ2.setLayout (new BoxLayout (listBateauJ2, BoxLayout.Y_AXIS));

        validerPlacementBateau.setBackground(Color.green);
        validerPlacementBateau.setPreferredSize(new Dimension(200,100));
        validerPlacementBateau.setText("VALIDER");

        plateau.add(listBateauJ1);
        plateau.add(Grille1);
        plateau.add(Grille2);
        plateau.add(listBateauJ2);
        plateau.add(validerPlacementBateau);

        //******************           CardLayout           ****************
        container.add(Menu, "menu");
        container.add(NombreBateau, "nbBat");
        container.add(Mode, "mode");
        container.add(plateau, "plateau");
        c.show(container, "menu");
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
    public void addjvjListener(ActionListener ListenForjvjButton){
        jvj.addActionListener(ListenForjvjButton);
    }
    public void addjvoListener(ActionListener ListenForjvoButton){
        jvo.addActionListener(ListenForjvoButton);
    }
    public void addovoListener(ActionListener ListenForovoButton){
        ovo.addActionListener(ListenForovoButton);
    }
    public void addValidNBListener(ActionListener ListenForValidNBButton){
        validNB.addActionListener(ListenForValidNBButton);
    }
    public void addclassiqueListener(ActionListener ListenForclassiqueButton){
        classique.addActionListener(ListenForclassiqueButton);
    }
    public void addradarListener(ActionListener ListenForradarButton){
        radar.addActionListener(ListenForradarButton);
    }
    public void addartillerieListener(ActionListener ListenForartillerieButton){
        artillerie.addActionListener(ListenForartillerieButton);
    }
    public void addcoderougeListener(ActionListener ListenForcoderougeButton){
        coderouge.addActionListener(ListenForcoderougeButton);
    }
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
    public void addlistBateauJ1Listener(ActionListener ListenForBateauJ1){
        for(int i = 0; i < 10; i++){
            buttonBateauJ1[i].addActionListener(ListenForBateauJ1);
        }
    }
    public void addlistBateauJ2Listener(ActionListener ListenForBateauJ1){
        for(int i = 0; i < 10; i++){
            buttonBateauJ2[i].addActionListener(ListenForBateauJ1);
        }
    }

    public void addvaliderPlacementListener(ActionListener ListenForPlacement){
        validerPlacementBateau.addActionListener(ListenForPlacement);
    }

    public int getComboBoxNbBat(){
        return Integer.parseInt(cb.getItemAt(cb.getSelectedIndex()).toString());
    }

    public void drawGrille1(String[][] maGrille, boolean hide){
        for (int i = 0; i < 10; i++){
            for (int j=0; j < 10; j++){
                CelluleGrille1[i][j].setNom(maGrille[i][j]);
                if(maGrille[i][j] == null){
                    CelluleGrille1[i][j].setColor(Color.CYAN);
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
                }else{CelluleGrille1[i][j].setColor(Color.CYAN);}
            }
        }
    }
    public void drawGrille2(String[][] maGrille, boolean hide){
        for (int i = 0; i < 10; i++){
            for (int j=0; j < 10; j++) {
                CelluleGrille2[i][j].setNom(maGrille[i][j]);
                if (maGrille[i][j] == null) {
                    CelluleGrille2[i][j].setColor(Color.CYAN);
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
                }else{CelluleGrille2[i][j].setColor(Color.CYAN);}
            }
        }
    }

}