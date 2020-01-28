package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;

public class Aff extends JFrame {
    
    public CardLayout mainPanel = new CardLayout();
    public JPanel container = new JPanel();


    public Partie p = new Partie();
    public Affichage a = new Affichage(p);

    public Menu1 m1 = new Menu1(this);
    public Menu2 m2 = new Menu2(this);


    public Aff(){

        container.add(m1, "menu1");
        container.add(m2, "menu2");
        container.add(a, "grille");
        mainPanel.show(container, "menu1");
        this.add(container);
        BatailleController c = new BatailleController(a, p);



    }

    public void setContainer(String card) {
        mainPanel.show(container, card);
    }
}

