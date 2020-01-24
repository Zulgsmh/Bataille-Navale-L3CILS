package view;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private JButton n1 = new JButton("1");
    private JButton n2 = new JButton("2");
    private JButton n3 = new JButton("3");
    private JButton n4 = new JButton("4");
    private JButton n5 = new JButton("5");

    private JPanel plateau = new JPanel();
    private JPanel Grille1 = new JPanel();
    private JPanel Grille2 = new JPanel();
    private cellule[][] CelluleGrille1 = new cellule[10][10];
    private cellule[][] CelluleGrille2 = new cellule[10][10];

    public Affichage(){
        ListenForMouse lForMouse = new ListenForMouse();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,600);
        container.setLayout(c);

        Menu.add(jvj);
        Menu.add(jvo);
        Menu.add(ovo);

        Mode.add(classique);
        Mode.add(radar);
        Mode.add(artillerie);
        Mode.add(coderouge);

        NombreBateau.add(n1);
        NombreBateau.add(n2);
        NombreBateau.add(n3);
        NombreBateau.add(n4);
        NombreBateau.add(n5);


        Grille1.setBackground(Color.black);
        Grille1.setPreferredSize( new Dimension( 400, 400 ) );
        Grille1.setLayout(new GridLayout(10,10));
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                CelluleGrille1[i][j] = new cellule(i, j, "j1");
                CelluleGrille1[i][j].addMouseListener(lForMouse);
                Grille1.add(CelluleGrille1[i][j]);
            }
        }
        Grille2.setBackground(Color.BLUE);
        Grille2.setPreferredSize( new Dimension( 400, 400 ) );
        Grille2.setLayout(new GridLayout(10,10));
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                CelluleGrille2[i][j] = new cellule(i, j, "j2");
                CelluleGrille2[i][j].addMouseListener(lForMouse);
                Grille2.add(CelluleGrille2[i][j]);
            }
        }


        plateau.add(Grille1);
        plateau.add(Grille2);


        container.add(Menu, "menu");
        container.add(Mode, "mode");
        container.add(plateau, "plateau");
        c.show(container, "menu");
        this.add(container);

    }
    public void setContainer(String card){
        c.show(container, card);
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
    public void drawGrille1(String[][] Grille1){
        for (int i = 0; i < 10; i++){
            for (int j=0; j < 10; j++){
                //faire des truc sur les gru
            }
        }
    }

}