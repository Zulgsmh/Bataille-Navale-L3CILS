package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Grille extends JPanel {

    private CardLayout c = new CardLayout();

    Partie partie ;

    private JPanel NombreBateau = new JPanel();

    private String[] num = {"1", "2", "3", "4", "5"};
    private JComboBox cb = new JComboBox(num);
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
    private String[] bateauName = {"PorteAvion", "SousMarin", "CuirasséFurtif1", "CuirasséFurtif2", "Zodiac"};
    private Bateau bateauSelect = new Bateau("", true);
    private Boolean sens = false;

    public Grille(Partie p) {

        this.partie = p;
        this.setSize(1200, 600);


        //*******************  NombreBateau *******************


        cb.setBounds(50, 50, 100, 400);
        NombreBateau.add(cb);
        NombreBateau.add(validNB);


        //*******************  Plateau de JEu ********************

        //définition de la grille1
        Grille1.setBackground(Color.black);
        Grille1.setPreferredSize(new Dimension(400, 400));
        Grille1.setLayout(new GridLayout(10, 10));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                CelluleGrille1[i][j] = new Cellule(i, j, "j1");
                CelluleGrille1[i][j].setBorder(BorderFactory.createLineBorder(Color.black));

                Grille1.add(CelluleGrille1[i][j]);
            }
        }
        //définition de la grille2
        Grille2.setBackground(Color.BLUE);
        Grille2.setPreferredSize(new Dimension(400, 400));
        Grille2.setLayout(new GridLayout(10, 10));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                CelluleGrille2[i][j] = new Cellule(i, j, "j2");
                CelluleGrille2[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                Grille2.add(CelluleGrille2[i][j]);
            }
        }

        listBateauJ1.setBackground(Color.GRAY);
        listBateauJ1.setPreferredSize(new Dimension(150, 400));
        for (int i = 0; i < 10; i++) {
            Boolean vertical;
            vertical = i % 2 == 0;
            buttonBateauJ1[i] = new Bateau("j1", vertical);
            buttonBateauJ1[i].setText(bateauName[i / 2]);
            listBateauJ1.add(buttonBateauJ1[i]);
        }
        listBateauJ1.setLayout(new BoxLayout(listBateauJ1, BoxLayout.Y_AXIS));

        listBateauJ2.setBackground(Color.GRAY);
        listBateauJ2.setPreferredSize(new Dimension(150, 400));
        for (int i = 0; i < 10; i++) {
            Boolean vertical;
            vertical = i % 2 == 0;
            buttonBateauJ2[i] = new Bateau("j2", vertical);
            buttonBateauJ2[i].setText(bateauName[i / 2]);
            listBateauJ2.add(buttonBateauJ2[i]);
        }
        listBateauJ2.setLayout(new BoxLayout(listBateauJ2, BoxLayout.Y_AXIS));

        validerPlacementBateau.setBackground(Color.green);
        validerPlacementBateau.setPreferredSize(new Dimension(200, 100));
        validerPlacementBateau.setText("VALIDER");

        //*******************  Style Plateau de JEu ********************
        plateau.setBackground(Color.GRAY);
        plateau.add(listBateauJ1);
        plateau.add(Grille1);
        plateau.add(Grille2);
        plateau.add(listBateauJ2);
        plateau.add(validerPlacementBateau);


    }

    public void setSelectBateau(Bateau bat) {
        this.bateauSelect = bat;
    }

    public Bateau getSelectBateau() {
        return this.bateauSelect;
    }





    public void addValidNBListener(ActionListener ListenForValidNBButton) {
        validNB.addActionListener(ListenForValidNBButton);
    }

    public void addGrille1Listener(BatailleController.ListenForMouse lForMouse) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille1[i][j].addMouseListener(lForMouse);
            }
        }
    }

    public void addGrille2Listener(BatailleController.ListenForMouse lForMouse) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille2[i][j].addMouseListener(lForMouse);
            }
        }
    }

    public void addlistBateauJ1Listener(ActionListener ListenForBateauJ1) {
        for (int i = 0; i < 10; i++) {
            buttonBateauJ1[i].addActionListener(ListenForBateauJ1);
        }
    }

    public void addlistBateauJ2Listener(ActionListener ListenForBateauJ1) {
        for (int i = 0; i < 10; i++) {
            buttonBateauJ2[i].addActionListener(ListenForBateauJ1);
        }
    }

    public void addvaliderPlacementListener(ActionListener ListenForPlacement) {
        validerPlacementBateau.addActionListener(ListenForPlacement);
    }

    public void drawGrille1(String[][] maGrille, boolean hide) {


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille1[i][j].setNom(maGrille[i][j]);
                if (maGrille[i][j] == null) {
                    CelluleGrille1[i][j].setColor(Color.CYAN);
                } else if (maGrille[i][j].equals("PLOF")) {
                    CelluleGrille1[i][j].setColor(Color.black);
                } else if (maGrille[i][j].equals("SHOT")) {
                    CelluleGrille1[i][j].setColor(Color.getColor("orange"));
                } else if (!hide) {
                    if (maGrille[i][j].equals("PORT")) {
                        CelluleGrille1[i][j].setColor(Color.getColor("marron"));
                    } else if (maGrille[i][j].equals("SOUS")) {
                        CelluleGrille1[i][j].setColor(Color.yellow);
                    } else if (maGrille[i][j].equals("CUI1")) {
                        CelluleGrille1[i][j].setColor(Color.pink);
                    } else if (maGrille[i][j].equals("CUI2")) {
                        CelluleGrille1[i][j].setColor(Color.MAGENTA);
                    } else if (maGrille[i][j].equals("ZODI")) {
                        CelluleGrille1[i][j].setColor(Color.green);
                    }
                } else {
                    CelluleGrille1[i][j].setColor(Color.CYAN);
                }
            }
        }
    }

    public void drawGrille2(String[][] maGrille, boolean hide) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CelluleGrille2[i][j].setNom(maGrille[i][j]);
                if (maGrille[i][j] == null) {
                    CelluleGrille2[i][j].setColor(Color.CYAN);
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
                    CelluleGrille2[i][j].setColor(Color.CYAN);
                }
            }

        }


    }
}

