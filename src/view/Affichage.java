package view;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;
import view.*;


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

    private  JOptionPane jop1;


    private JPanel NombreBateau = new JPanel();

    private String num[]={"1","2","3","4","5"};
    private JComboBox cb=new JComboBox(num);
    private JButton validNB = new JButton();



    private JPanel plateau = new JPanel();

    private JPanel Grille1 = new JPanel();
    private JPanel Grille2 = new JPanel();
    private JPanel listBateauJ1 = new JPanel();
    private JPanel listBateauJ2 = new JPanel();
    //creation bateau aleatoire:
    private JButton RandomBateau = new JButton();
    private JButton validerPlacementBateau = new JButton();
    private cellule[][] CelluleGrille1 = new cellule[10][10];
    private cellule[][] CelluleGrille2 = new cellule[10][10];
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
                CelluleGrille1[i][j] = new cellule(i, j, "j1");
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
                CelluleGrille2[i][j] = new cellule(i, j, "j2");
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

        //Bouton bateau aleatoire:
        RandomBateau.setBackground(Color.RED);
        RandomBateau.setPreferredSize(new Dimension(200,100));
        RandomBateau.setText("Bateau aléatoire");

        plateau.add(listBateauJ1);
        plateau.add(Grille1);
        plateau.add(Grille2);
        plateau.add(listBateauJ2);
        plateau.add(validerPlacementBateau);
        //ajout du boutton bateau random au plateau
        plateau.add(RandomBateau);

        //******************           CardLayout           ****************
        //container.add(Menu, "menu");
        container.add(NombreBateau, "nbBat");
       //container.add(Mode, "mode");
        container.add(plateau, "plateau");
        c.show(container, "nbBat");
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
        Gui t1 = new Gui();
        this.setContentPane(t1);
        this.validate();
    }

    public JOptionPane getAfficherPopUpVictoire(){ return this.jop1 ; }

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

    public void addRandomBateauListener(ActionListener ListenForRandomBateau){
        RandomBateau.addActionListener(ListenForRandomBateau);
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

class cellule extends JPanel {
    private int x,y;
    private String nom = "";
    private String appartient;
    cellule(int x, int y, String appart){
        this.x = x;
        this.y = y;
        this.appartient = appart;
        this.setBackground(Color.CYAN);

    }

    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }

    public String getAppartient() {
        return appartient;
    }
    public void setColor(Color color){
        this.setBackground(color);
    }
    public void setNom(String nom){
        this.nom = nom;
    }
}
class Bateau extends JButton {
    private String equipe;
    private Boolean sens;
    Bateau(String equipe, Boolean sens){
        this.equipe = equipe;
        this.sens = sens;

    }

    public String getEquipe(){ return this.equipe; }
    public Boolean getSens(){ return this.sens; }
}
class BatailleController {

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
                if(partie.getJ2DoitTirer()) {
                    for(int i =0 ; i< partie.j1.getListNavire().length ; i++){
                        if(partie.j1.getListNavire()[i].getEstPose()) {
                            System.out.println(partie.j1.getListNavire()[i].getNom());
                            System.out.println(partie.j1.getListNavire()[i].getVie());
                            //Boîte du message d'information
                        }
                    }
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
                    partie.j2.getShot(parent.getx() + 1, parent.gety() + 1);
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
            cellule parent = (cellule)e.getSource();
            if (parent.getBackground().equals(Color.CYAN)) {
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
                parent.setBackground(Color.CYAN);
            }
            if((partie.getJ1DoitTirer()||partie.getJ2DoitTirer() )&& parent.getBackground().equals(Color.red)){
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
