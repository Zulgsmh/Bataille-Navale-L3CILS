package view;

import controller.BatailleController;
import model.Partie;

import javax.swing.*;
import java.awt.*;

public class Aff extends JFrame {

    public CardLayout mainPanel = new CardLayout();
    public JPanel container = new JPanel();


    public Partie p = new Partie();

    public Grille g = new Grille(p);
    public Menu1 m1 = new Menu1(this);
    public Menu2 m2 = new Menu2(this);


    public Aff(){

        container.add(m1, "menu1");
        container.add(m2, "menu2");
        container.add(g, "grille");
        container.setLayout(mainPanel);
        mainPanel.show(container, "menu1");
        this.add(container);
        BatailleController c = new BatailleController(g, p);

    }

    public void setContainer(String card) {
        mainPanel.show(container, card);
    }
}

